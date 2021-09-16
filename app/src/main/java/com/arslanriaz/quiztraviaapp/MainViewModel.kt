package com.arslanriaz.quiztraviaapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {


    private val _response = MutableLiveData<ApiData>()
    val response: LiveData<ApiData>
        get() = _response

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    init {
        _loading.value = true
    }

    fun getApiResponse(cat: Int, diff: String, type: String, amount: Int) {
        val Base_URl = "https://opentdb.com/"

        lateinit var responseBody: ApiData


        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base_URl)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData(cat, amount, diff, type)

        retrofitData.enqueue(object : Callback<ApiData?> {
            override fun onResponse(
                call: Call<ApiData?>,
                response: Response<ApiData?>

            ) {
                _response.value = response.body()
                _loading.value = false

            }

            override fun onFailure(call: Call<ApiData?>, t: Throwable) {
                _loading.value = false

                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })

    }
}