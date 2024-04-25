package com.example.notdefterimapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notdefterimapp.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class NotGuncelleViwModel @Inject constructor(var nrepo:NotlarRepository):ViewModel() {

    fun buttonNotGuncelle(notId:Int,notBaslik: String,notAciklama:String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.buttonNotGuncelle(notId,notBaslik,notAciklama)
        }
    }

}