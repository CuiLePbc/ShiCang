package com.cuile.shicang

import retrofit2.http.GET

interface WebService {

    @GET("/CuiLePbc/RestApiTest/posts/1")
    suspend fun getPoem(): Poem
}