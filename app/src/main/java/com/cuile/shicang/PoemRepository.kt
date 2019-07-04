package com.cuile.shicang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PoemRepository {

    private lateinit var webService: WebService

    suspend fun getPoem(): LiveData<Poem> {

        val data = MutableLiveData<Poem>()



        webService =
            Retrofit.Builder()
                .baseUrl("http://my-json-server.typicode.com").addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebService::class.java)
        data.value = webService.getPoem()


        return data
    }
}