package com.example.notdefterimapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notdefterimapp.data.entiti.Notlar

@Database(entities = [Notlar::class], version = 1)
abstract class VeriTabani:RoomDatabase() {
    abstract fun getNotlarDao():NotlarDao
}