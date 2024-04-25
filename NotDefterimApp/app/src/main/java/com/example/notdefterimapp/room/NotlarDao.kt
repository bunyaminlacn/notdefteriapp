package com.example.notdefterimapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notdefterimapp.data.entiti.Notlar

@Dao
interface NotlarDao {
    @Query("SELECT * FROM notlar")
    suspend fun notlariYukle():List<Notlar>

    @Insert
    suspend fun kaydet(not:Notlar)

    @Update
    suspend fun guncelle(not:Notlar)

    @Delete
    suspend fun sil(not:Notlar)

    @Query("SELECT * FROM notlar WHERE not_baslik like '%' || :aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi:String):List<Notlar>
}