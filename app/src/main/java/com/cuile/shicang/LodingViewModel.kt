package com.cuile.shicang

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class LodingViewModel : ViewModel(), LifecycleObserver {

    private val poemRepository: PoemRepository = PoemRepository()

    var poem: LiveData<Poem>

    init {
        poem = MutableLiveData<Poem>()
        viewModelScope.launch {
            poem = poemRepository.getPoem()
        }
    }

}