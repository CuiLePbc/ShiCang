package com.cuile.shicang

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides

@Module
class LodingViewModelModule {

    @Provides
    fun provideMutableLiveDataPoem(): MutableLiveData<Poem> = MutableLiveData()

    @Provides
    fun providePoemRepository(): PoemRepository = PoemRepository()

}