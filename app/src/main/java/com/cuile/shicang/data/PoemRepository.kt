package com.cuile.shicang.data

import com.cuile.shicang.data.api.WebService
import com.cuile.shicang.data.db.PoemDao
import com.cuile.shicang.data.model.Poem
import kotlinx.coroutines.coroutineScope


class PoemRepository private constructor(private val poemDao: PoemDao, private val webService: WebService){
    companion object {
        @Volatile private var instance: PoemRepository? = null
        fun getInstance(poemDao: PoemDao, webService: WebService) =
            instance ?: synchronized(this) {
                instance
                    ?: PoemRepository(poemDao, webService).also { instance = it }
            }
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