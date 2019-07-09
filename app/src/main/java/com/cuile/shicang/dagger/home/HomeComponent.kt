package com.cuile.shicang.dagger.home

import com.cuile.shicang.dagger.BaseFragmentComponent
import com.cuile.shicang.dagger.CoreComponent
import com.cuile.shicang.dagger.scope.FeatureScope
import com.cuile.shicang.ui.home.HomeFragment
import dagger.Component

@Component(modules = [HomeFragmentModule::class], dependencies = [CoreComponent::class])
@FeatureScope
interface HomeComponent : BaseFragmentComponent<HomeFragment> {

    @Component.Builder
    interface Builder {
        fun build(): HomeComponent
        fun coreCompnent(component: CoreComponent): Builder
        fun homeModule(homeFragmentModule: HomeFragmentModule): Builder
    }

}