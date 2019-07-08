package com.cuile.shicang.data.api

import com.cuile.shicang.data.model.Poem
import retrofit2.http.GET

interface WebService {

    @GET("/CuiLePbc/RestApiTest/posts/1")
    suspend fun getPoem(): Poem
}