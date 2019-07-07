package com.cuile.shicang

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PoemRepository private constructor(private val poemDao: PoemDao){
    companion object {
        @Volatile private var instance: PoemRepository? = null
        fun getInstance(poemDao: PoemDao) =
            instance ?: synchronized(this) {
                instance ?: PoemRepository(poemDao).also { instance = it }
            }
    }


    private val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebService::class.java)
    }

    suspend fun refreshPoem() {
        val newPoem = webService.getPoem()
        poemDao.insertPoem(newPoem)
    }

    suspend fun getPoem(): Poem {
        var allPoems = listOf<Poem>()

        coroutineScope {
            allPoems = poemDao.getAllLodingPoems()
        }

        if (allPoems.isNullOrEmpty()) {
            val newPoem = webService.getPoem()
            poemDao.insertPoem(newPoem)
            allPoems = listOf(newPoem)
        }

        return allPoems[0]
    }
}