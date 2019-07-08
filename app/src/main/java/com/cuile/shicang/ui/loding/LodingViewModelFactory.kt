package com.cuile.shicang.ui.loding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cuile.shicang.data.PoemRepository
import javax.inject.Inject

class LodingViewModelFactory @Inject constructor(private val poemRepository: PoemRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = LodingViewModel(
        poemRepository
    ) as T
}