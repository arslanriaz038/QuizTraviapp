package com.arslanriaz.quiztraviaapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.arslanriaz.quiztraviaapp.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), MyRvAdapter.InnerClickListner {


    lateinit var database: QuestionsDatabase

    var allQuestions: ArrayList<Result> = ArrayList()
    val myAdapter by lazy { MyAdapter(this, allQuestions) }
    val category by lazy { intent.extras!!.getInt("cat") }
    val diff by lazy { intent.extras!!.getString("diff") }
    val type by lazy { intent.extras!!.getString("type") }
    val amount = 10

    lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database =
            Room.databaseBuilder(applicationContext, QuestionsDatabase::class.java, "questionsDB")
                .build()


        //  database.questionDao().deleteAll()

        binding.recyclerView.adapter = myAdapter

        viewModel.response.observe(this) { result ->
            allQuestions.clear()
            allQuestions.addAll(result.getShuffeledResult())
            myAdapter.notifyItemRangeInserted(0, allQuestions.size)

        }

        viewModel.loading.observe(this, Observer { loading ->
            binding.progressbar.isVisible = loading
        })

        viewModel.getApiResponse(category, diff!!, type!!, amount)

        binding.submit.setOnClickListener {
            val correctCount = allQuestions.filter { it.selected_opt == it.correct_answer }.count()

            val questionsList: ArrayList<String> = ArrayList()

            for (i in 0..9) {

                questionsList.add(allQuestions[i].question)

            }
            Log.d("QuestionList", questionsList.toString())

            val answersList: ArrayList<String> = ArrayList()

            for (i in 0..9) {

                answersList.add(allQuestions[i].selected_opt)

            }
            Log.d("AnswersList", answersList.toString())

            GlobalScope.launch {

                database.questionDao().deleteAll()

                for (i in 0..9) {

                    if (answersList[i] == null)
                        database.questionDao()
                            .insertQuestion(Questions(0, questionsList[i], "Not Answered"))
                    else
                        database.questionDao()
                            .insertQuestion(Questions(0, questionsList[i], answersList[i]))

                }

            }

            database.questionDao().getQuestions().observe(this, {
                Log.d("Database", it.toString())
            })

            binding.count.text = "Score: $correctCount/10"

            val intent = Intent(this, ResultAfterSubmit()::class.java)
            intent.putExtra("count", correctCount)
            startActivity(intent)

        }

    }

    override fun onItemClick(outerPos: Int, innerPos: Int) {
        allQuestions[outerPos].selected_opt = allQuestions[outerPos].all_options[innerPos]
        myAdapter.notifyItemChanged(outerPos, allQuestions[outerPos])
    }

}