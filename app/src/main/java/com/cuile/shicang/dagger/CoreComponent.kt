package com.cuile.shicang.dagger

import dagger.Component
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [CoreDataModule::class])
interface CoreComponent {

    @Component.Builder
    interface Builder {
        fun build(): CoreComponent
    }

    fun provideGsonConvertFactory(): GsonConverterFactory

}