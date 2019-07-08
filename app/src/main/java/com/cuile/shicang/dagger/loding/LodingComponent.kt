package com.cuile.shicang.dagger.loding

import com.cuile.shicang.dagger.BaseActivityComponent
import com.cuile.shicang.dagger.CoreComponent
import com.cuile.shicang.ui.loding.LodingActivity
import dagger.Component

@Component(modules = [LodingModule::class], dependencies = [CoreComponent::class])
interface LodingComponent : BaseActivityComponent<LodingActivity> {

    @Component.Builder
    interface Builder {
        fun build(): LodingComponent
        fun coreCompnent(component: CoreComponent): Builder
        fun lodingModule(module: LodingModule): Builder
    }
}