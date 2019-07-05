package com.cuile.shicang

import dagger.Component

@Component(modules = [LodingViewModelModule::class])
interface LodingComponent {

    fun inject(viewModel: LodingViewModel)

}