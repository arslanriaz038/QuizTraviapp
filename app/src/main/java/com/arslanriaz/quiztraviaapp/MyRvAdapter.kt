package com.arslanriaz.quiztraviaapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arslanriaz.quiztraviaapp.databinding.SinglelistOptionBinding

class MyRvAdapter(
    private val outerPos: Int,
    private val onClickListener: InnerClickListner,
    val result: Result
) : RecyclerView.Adapter<MyRvAdapter.ListViewHolder>() {

    var optionsList: List<String> = result.all_options

    class ListViewHolder(val binding: SinglelistOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            SinglelistOptionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.ctOption.text = optionsList[position]
        holder.binding.ctOption.isChecked = (result.selected_opt == optionsList[position])

        holder.itemView.setOnClickListener { adapterView ->
            onClickListener.onItemClick(outerPos, position)
        }
    }

    override fun getItemCount(): Int {
        return optionsList.size
    }


    interface InnerClickListner {
        fun onItemClick(outerPos: Int, innerPos: Int)
    }

    public fun correctAnswers(
        holder: MyRvAdapter.ListViewHolder,
        myadapterPosition: Int
    ) {

        if (holder.binding.ctOption.text == result.correct_answer) {
            //  holder.ct_option.setChecked(true)
            holder.binding.ctOption.setBackgroundColor(Color.parseColor("#6CB66B"))

        }
    }
}




