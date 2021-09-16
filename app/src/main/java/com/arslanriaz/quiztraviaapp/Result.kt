package com.arslanriaz.quiztraviaapp

import androidx.lifecycle.MutableLiveData

data class Result(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    val question: String,
    val type: String,
    var selected_opt: String,
    var all_options: ArrayList<String>,
) {

    fun getAllOptions():ArrayList<String>{
        val arrayOp:ArrayList<String> = ArrayList()
        arrayOp.add(correct_answer)
        arrayOp.addAll(incorrect_answers)
        arrayOp.shuffle()
        return arrayOp
    }



}