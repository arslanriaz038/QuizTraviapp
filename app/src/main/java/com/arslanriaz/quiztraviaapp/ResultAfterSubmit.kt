package com.arslanriaz.quiztraviaapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.arslanriaz.quiztraviaapp.databinding.ActivityResultAfterSubmitBinding

class ResultAfterSubmit() : AppCompatActivity() {

    lateinit var binding: ActivityResultAfterSubmitBinding
    lateinit var database: QuestionsDatabase
   lateinit var  resultAdapter :ResultAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityResultAfterSubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database =
            Room.databaseBuilder(applicationContext, QuestionsDatabase::class.java, "questionsDB")
                .build()



        val count = intent.getSerializableExtra("count")
        val category = intent.getSerializableExtra("category")
      //  val diff = intent.getSerializableExtra("difficulty")

        binding.count.text = "Score: $count"
        binding.category.text = "Category: $category"

        var newlist = ArrayList<Questions>()

        database.questionDao().getQuestions().observe(this, {

            newlist.addAll(it)


        })
        resultAdapter = ResultAdapter(newlist)


        binding.recyclerView.adapter = resultAdapter

    }
}