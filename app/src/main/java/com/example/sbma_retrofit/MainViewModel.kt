package com.example.sbma_retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository: WebServiceRepository = WebServiceRepository()

    val presidentHits = MutableLiveData<Int>()

    fun getHits(president: President){
        viewModelScope.launch(Dispatchers.IO) {
            val retrievedPresidentHits = repository.getHits(president)
            presidentHits.postValue(retrievedPresidentHits.query?.searchinfo?.totalhits ?: 0)
        }
    }
}