package com.cuile.shicang.ui.loding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuile.shicang.data.PoemRepository
import com.cuile.shicang.data.model.Poem
import kotlinx.coroutines.*

class LodingViewModel(private val poemRepository: PoemRepository) : ViewModel() {

    val poem: MutableLiveData<Poem> by lazy { MutableLiveData<Poem>() }
    val showStatus: MutableLiveData<Boolean> = MutableLiveData()

    init {
        showStatus.value = false
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                coroutineScope {
                    poem.postValue(poemRepository.getPoem())
                }

                poemRepository.refreshPoem()
            }
        }

        viewModelScope.launch {
            delay(1000)
            showEnd()
        }

    }

    private fun showEnd() {
        showStatus.value = true
    }

}