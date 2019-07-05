package com.cuile.shicang

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class PoemRepositoryModule {

    @Provides
    fun provideWebService(): WebService =
        Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebService::class.java)
}