package com.cuile.shicang

class PoemRepository {

    init {
        DaggerPoemRepositoryComponent
            .create()
            .inject(this)
    }
    lateinit var webService: WebService

    suspend fun getPoem(): Poem {

        return webService.getPoem()
    }
}