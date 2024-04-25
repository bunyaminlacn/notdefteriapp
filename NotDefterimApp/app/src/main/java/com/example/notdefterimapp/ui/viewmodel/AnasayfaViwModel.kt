package com.example.notdefterimapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notdefterimapp.data.entiti.Notlar
import com.example.notdefterimapp.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViwModel @Inject constructor(var nrepo:NotlarRepository):ViewModel() {

    var notlarListesi=MutableLiveData<List<Notlar>>()

    init {
        notlariYukle()
    }

    fun notlariYukle(){
        CoroutineScope(Dispatchers.Main).launch {
           notlarListesi.value= nrepo.notlariYukle()
        }
    }

    fun sil(notId:Int){
        CoroutineScope(Dispatchers.Main).launch {
           nrepo.sil(notId)
            notlariYukle()
        }
    }
    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value=nrepo.ara(aramaKelimesi)
        }
    }
}