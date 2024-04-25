package com.example.notdefterimapp.data.datasource

import android.util.Log
import com.example.notdefterimapp.data.entiti.Notlar
import com.example.notdefterimapp.room.NotlarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotlarDatasource (var ndao:NotlarDao) {


    suspend fun notlariYukle():List<Notlar> =
        withContext(Dispatchers.IO){
            var notlarLitesi=ArrayList<Notlar>()

            return@withContext ndao.notlariYukle()

        }
    suspend fun ara(aramaKelimesi:String):List<Notlar> =
        withContext(Dispatchers.IO) {
            return@withContext ndao.ara(aramaKelimesi)
        }




    suspend fun buttonNotEkle(notBaslik: String,notAciklama:String){
        val yeniNot=Notlar(0,notBaslik,notAciklama)
        ndao.kaydet(yeniNot)
    }

    suspend fun buttonNotGuncelle(notId:Int,notBaslik: String,notAciklama:String){

       val guncelNot=Notlar(notId,notBaslik,notAciklama)
       ndao.guncelle(guncelNot)
    }
    suspend fun sil(notId:Int){
       val silinenNot=Notlar(notId,"","")
       ndao.sil(silinenNot)

    }

}