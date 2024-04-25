package com.example.notdefterimapp.data.repo

import com.example.notdefterimapp.data.datasource.NotlarDatasource
import com.example.notdefterimapp.data.entiti.Notlar

class NotlarRepository(var nds:NotlarDatasource) {

    suspend fun buttonNotEkle(notBaslik: String,notAciklama:String)
    =nds.buttonNotEkle(notBaslik,notAciklama)

    suspend fun buttonNotGuncelle(notId:Int,notBaslik: String,notAciklama:String)
    =nds.buttonNotGuncelle(notId,notBaslik,notAciklama)

    suspend fun sil(notId:Int)=nds.sil(notId)

    suspend fun notlariYukle():List<Notlar> = nds.notlariYukle()

    suspend fun ara(aramaKelimesi:String):List<Notlar> =nds.ara(aramaKelimesi)
}
