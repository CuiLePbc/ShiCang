package com.cuile.shicang

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LodingViewModel : ViewModel() {

    private val poemRepository: PoemRepository = PoemRepository()

    val poem: MutableLiveData<Poem> = MutableLiveData<Poem>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                poem.postValue(poemRepository.getPoem())
            }
        }
    }

}