package com.cuile.shicang.dagger.loding

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.cuile.shicang.data.PoemRepository
import com.cuile.shicang.data.api.WebService
import com.cuile.shicang.ui.loding.LodingViewModel
import com.cuile.shicang.ui.loding.LodingViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class LodingModule {

    @Provides
    fun provideWebService(gsonConverterFactory: GsonConverterFactory) {
        Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com")
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(WebService::class.java)
    }

    @Provides
    fun provideViewModel(factory: LodingViewModelFactory, fragmentActivity: FragmentActivity): LodingViewModel =
        ViewModelProviders.of(fragmentActivity, factory).get(LodingViewModel::class.java)

}