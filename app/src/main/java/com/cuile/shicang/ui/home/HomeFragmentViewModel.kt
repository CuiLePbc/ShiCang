package com.cuile.shicang.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cuile.shicang.data.model.Poem

class HomeFragmentViewModel : ViewModel() {
    val homePoem: MutableLiveData<Poem> by lazy { MutableLiveData<Poem>() }

    fun refreshHomePoem() {
        homePoem.postValue(Poem(0, "Hello world!", "Cuile", "HelloHelloHello", "", "",""))
    }
}
