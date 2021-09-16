package com.arslanriaz.quiztraviaapp

data class ApiData(
    val response_code: Int,
    val results: ArrayList<Result>
) {
    fun getShuffeledResult():ArrayList<Result> {
        val allResults:ArrayList<Result> = ArrayList()
        for (result in  results)
        {
            result.all_options=result.getAllOptions()
            allResults.add(result)
        }
        return allResults

    }
}