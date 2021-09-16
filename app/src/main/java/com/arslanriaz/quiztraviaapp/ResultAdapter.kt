package com.arslanriaz.quiztraviaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arslanriaz.quiztraviaapp.databinding.SingleResultItemBinding

class ResultAdapter(val questions: ArrayList<Questions>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    class ResultViewHolder(val binding: SingleResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            SingleResultItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {

        holder.binding.question.text = "Question: " + questions[position].question
        holder.binding.answer.text = "Answer: " +questions[position].selected_answer
    }

    override fun getItemCount(): Int {
       return questions.size
    }
}