package com.arslanriaz.quiztraviaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arslanriaz.quiztraviaapp.databinding.ActivityChooseCategoryDiffBinding
import java.util.*

class ChooseCategoryDiff : AppCompatActivity() {

    lateinit var binding: ActivityChooseCategoryDiffBinding
    var gridView: GridView? = null
    var gridArray: ArrayList<ItemCategory> = ArrayList<ItemCategory>()
    var customGridAdapter: CustomGripAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseCategoryDiffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Spinner
        val difficulty = resources.getStringArray(R.array.Difficulty)
        val type = resources.getStringArray(R.array.Type)

        val spinner = binding.spinner
        val adapter = ArrayAdapter(
            this,
            R.layout.spiner_layout, difficulty
        )
        spinner.adapter = adapter


        val spinnertype = binding.spinnerType
        val adaptertype = ArrayAdapter(
            this,
            R.layout.spiner_layout, type
        )
        spinnertype.adapter = adaptertype


        //Gridview
        gridView = findViewById<GridView>(R.id.gv_category)
        addCategoryData()
        customGridAdapter = CustomGripAdapter(gridArray, this)
        gridView?.adapter = customGridAdapter



        gridView?.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val tv = view.findViewById<View>(R.id.item_text) as TextView //your textview id


            val i = Intent(this, MainActivity::class.java)


            val category = position + 9

            val difficultyLevel: String = spinner.selectedItem.toString()

            val type: String = spinnertype.selectedItem.toString()


            i.putExtra("cat", category)
            i.putExtra("diff", difficultyLevel)
            i.putExtra("type", type)

            startActivity(i)
        })


    }

    private fun addCategoryData() {
        val cat1 = ItemCategory()
        cat1.title = "Nature"
        cat1.image = R.drawable.nature
        gridArray.add(cat1)

        val cat2 = ItemCategory()
        cat2.title = "Music"
        cat2.image = R.drawable.music
        gridArray.add(cat2)

        val cat3 = ItemCategory()
        cat3.title = "Film"
        cat3.image = R.drawable.film
        gridArray.add(cat3)

        val cat4 = ItemCategory()
        cat4.title = "Video Games"
        cat4.image = R.drawable.video_game
        gridArray.add(cat4)

        val cat5 = ItemCategory()
        cat5.title = "Board Games"
        cat5.image = R.drawable.board_games
        gridArray.add(cat5)

        val cat6 = ItemCategory()
        cat6.title = "Sports"
        cat6.image = R.drawable.sports
        gridArray.add(cat6)

        val cat7 = ItemCategory()
        cat7.title = "Art"
        cat7.image = R.drawable.art
        gridArray.add(cat7)

        val cat8 = ItemCategory()
        cat8.title = "Television"
        cat8.image = R.drawable.television
        gridArray.add(cat8)

        val cat9 = ItemCategory()
        cat9.title = "Gadgets"
        cat9.image = R.drawable.gadgets
        gridArray.add(cat9)

        val cat10 = ItemCategory()
        cat10.title = "Computer Science"
        cat10.image = R.drawable.computer_science
        gridArray.add(cat10)

        val cat11 = ItemCategory()
        cat11.title = "General knowledge"
        cat11.image = R.drawable.general_knowledge
        gridArray.add(cat11)

        val cat12 = ItemCategory()
        cat12.title = "vehicles"
        cat12.image = R.drawable.vehicles
        gridArray.add(cat12)


    }
}