package com.arslanriaz.quiztraviaapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Questions::class], version = 1)
abstract class QuestionsDatabase : RoomDatabase() {

abstract fun questionDao() :QuestionDao
}