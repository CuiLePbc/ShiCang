package com.cuile.shicang

import dagger.Component

@Component(modules = [PoemRepositoryModule::class])
interface PoemRepositoryComponent {
    fun inject(poemRepository: PoemRepository)
}