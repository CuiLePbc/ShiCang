package com.cuile.shicang.dagger.home

import com.cuile.shicang.dagger.CoreComponent
import com.cuile.shicang.dagger.DaggerCoreComponent
import com.cuile.shicang.ui.home.HomeFragment

private val coreComponent: CoreComponent by lazy {
    DaggerCoreComponent.builder().build()
}

fun inject(fragment: HomeFragment) {

    DaggerHomeComponent.builder()
        .coreCompnent(coreComponent)
        .homeModule(HomeFragmentModule(fragment))
        .build()
        .inject(fragment)
}