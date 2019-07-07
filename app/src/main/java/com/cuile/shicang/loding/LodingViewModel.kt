package com.cuile.shicang.loding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuile.shicang.Poem
import com.cuile.shicang.PoemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LodingViewModel(private val poemRepository: PoemRepository) : ViewModel() {

    val poem: MutableLiveData<Poem> by lazy { MutableLiveData<Poem>() }

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                coroutineScope {
                    poem.postValue(poemRepository.getPoem())
                }

                poemRepository.refreshPoem()
            }
        }
    }

}