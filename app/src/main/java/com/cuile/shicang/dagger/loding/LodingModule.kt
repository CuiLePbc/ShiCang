package com.cuile.shicang.dagger.loding

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.cuile.shicang.data.PoemRepository
import com.cuile.shicang.data.api.WebService
import com.cuile.shicang.data.db.AppDataBase
import com.cuile.shicang.data.db.PoemDao
import com.cuile.shicang.ui.loding.LodingActivity
import com.cuile.shicang.ui.loding.LodingViewModel
import com.cuile.shicang.ui.loding.LodingViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class LodingModule(val lodingActivity: LodingActivity) {

    @Provides
    fun provideFragmentActivity(): FragmentActivity =
        this.lodingActivity

    @Provides
    fun provideWebService(gsonConverterFactory: GsonConverterFactory): WebService =
        Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com")
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(WebService::class.java)

    @Provides
    fun providePoemDao(fragmentActivity: FragmentActivity): PoemDao =
        Room.databaseBuilder(
            fragmentActivity.applicationContext,
            AppDataBase::class.java,
            "poems"
        )
            .build()
            .poemDao()

    @Provides
    fun providePoemRepository(poemDao: PoemDao, webService: WebService): PoemRepository =
        PoemRepository.getInstance(poemDao, webService)


    @Provides
    fun provideViewModel(
        factory: LodingViewModelFactory,
        fragmentActivity: FragmentActivity
    ): LodingViewModel =
        ViewModelProviders.of(fragmentActivity, factory).get(LodingViewModel::class.java)
}


