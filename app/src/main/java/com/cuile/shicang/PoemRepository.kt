package com.cuile.shicang

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PoemRepository @Inject constructor(){

    private lateinit var webService: WebService

    suspend fun getPoem(): Poem {
        webService =
            Retrofit.Builder()
                .baseUrl("http://my-json-server.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebService::class.java)

        return webService.getPoem()
    }
}