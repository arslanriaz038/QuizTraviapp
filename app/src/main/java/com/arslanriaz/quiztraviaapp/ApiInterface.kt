package com.arslanriaz.quiztraviaapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    //https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=multiple
    //https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=boolean

    @GET("api.php?")
    fun getData(

        @Query("category") cat: Int,
        @Query("amount") amount: Int,
        @Query("difficulty") diff: String,
        @Query("type") type: String
    ): Call<ApiData>


}