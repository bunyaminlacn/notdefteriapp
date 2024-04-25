package com.example.notdefterimapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notdefterimapp.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class NotEkleViwModel @Inject constructor(var nrepo:NotlarRepository):ViewModel() {
    fun buttonNotEkle(notBaslik: String,notAciklama:String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.buttonNotEkle(notBaslik,notAciklama)

        }
    }

}