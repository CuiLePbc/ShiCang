package com.cuile.shicang

import androidx.lifecycle.*
import dagger.internal.DaggerCollections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LodingViewModel : ViewModel() {

    @Inject
    lateinit var poemRepository: PoemRepository

    @Inject
    lateinit var poem: MutableLiveData<Poem>

    init {

        DaggerLodingComponent
            .create()
            .inject(this)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                poem.postValue(poemRepository.getPoem())
            }
        }
    }

}