package com.cuile.shicang.dagger.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.cuile.shicang.ui.home.HomeFragment
import com.cuile.shicang.ui.home.HomeFragmentViewModel
import com.cuile.shicang.ui.home.HomeFragmentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule(private val homeFragment: HomeFragment) {

    @Provides
    fun provideFragment(): Fragment = homeFragment

    @Provides
    fun provideHomeFragmentViewModel(fragment: Fragment, homeFragmentViewModelFactory: HomeFragmentViewModelFactory): HomeFragmentViewModel =
        ViewModelProviders.of(fragment, homeFragmentViewModelFactory).get(HomeFragmentViewModel::class.java)

}