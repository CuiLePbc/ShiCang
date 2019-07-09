package com.cuile.shicang.dagger.home

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.cuile.shicang.ui.home.HomeFragment
import com.cuile.shicang.ui.home.HomeFragmentViewModel
import com.cuile.shicang.ui.home.HomeFragmentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule(private val fragment: HomeFragment) {

    @Provides
    fun provideFragmentActivity(): FragmentActivity = fragment.requireActivity()

    @Provides
    fun provideHomeFragmentViewModel(activity: FragmentActivity): HomeFragmentViewModel =
        ViewModelProviders.of(activity, HomeFragmentViewModelFactory()).get(HomeFragmentViewModel::class.java)

}