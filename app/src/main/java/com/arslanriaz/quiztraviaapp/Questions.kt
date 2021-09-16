package com.arslanriaz.quiztraviaapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Questions")
data class Questions(

    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val question :String,
    val selected_answer : String

)
