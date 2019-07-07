package com.cuile.shicang.loding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cuile.shicang.PoemRepository

class LodingViewModelFactory(private val poemRepository: PoemRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = LodingViewModel(poemRepository) as T
}