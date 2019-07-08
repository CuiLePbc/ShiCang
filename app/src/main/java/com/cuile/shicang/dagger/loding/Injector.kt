package com.cuile.shicang.dagger.loding

import com.cuile.shicang.dagger.CoreComponent
import com.cuile.shicang.dagger.DaggerCoreComponent
import com.cuile.shicang.ui.loding.LodingActivity

private val coreComponent: CoreComponent by lazy {
    DaggerCoreComponent.builder().build()
}

fun inject(activity: LodingActivity) {
    DaggerLodingComponent.builder()
        .coreCompnent(coreComponent)
        .lodingModule(LodingModule())
        .build()
        .inject(activity)
}