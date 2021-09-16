package com.arslanriaz.quiztraviaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arslanriaz.quiztraviaapp.databinding.SingleRowBinding


class MyAdapter(
    private val onClickListener: MyRvAdapter.InnerClickListner, val results: ArrayList<Result>
) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: SingleRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            SingleRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.question.text=results[position].question
        holder.binding.myRVListViewId.adapter=MyRvAdapter(position,onClickListener,results[position])
    }

    override fun getItemCount(): Int {
        return results.size
    }

}

