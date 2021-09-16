package com.arslanriaz.quiztraviaapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGripAdapter(var gridList: List<ItemCategory>, var activity: Activity) : BaseAdapter() {
    override fun getCount(): Int {
        return gridList.size
    }

    override fun getItem(position: Int): Any {
        return gridList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(activity, R.layout.item_gridview, null)


        val tv_cat = view.findViewById<TextView>(R.id.item_text) as TextView
        val img_cat = view.findViewById<ImageView>(R.id.item_image)




        tv_cat.text = gridList.get(position).title
        val cat_pic = gridList.get(position).image

        val category_img = gridList.get(position).image
        img_cat.setImageResource(category_img)



        return view
    }
}