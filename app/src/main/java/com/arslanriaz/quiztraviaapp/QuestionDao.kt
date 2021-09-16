package com.arslanriaz.quiztraviaapp

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface QuestionDao {

    @Insert
    suspend fun insertQuestion(questions: Questions)

    @Update
    suspend fun updateQuestion(questions: Questions)

    @Delete
    suspend fun deleteQuestion(questions: Questions)

    @Query("SELECT * From Questions")
    fun getQuestions() : LiveData<List<Questions>>

    @Query("DELETE FROM Questions")
    suspend fun deleteAll()


}