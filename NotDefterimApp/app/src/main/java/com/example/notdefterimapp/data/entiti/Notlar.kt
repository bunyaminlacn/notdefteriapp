package com.example.notdefterimapp.data.entiti

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "notlar")
data class Notlar(@PrimaryKey(true) @ColumnInfo(name = "not_id") @NotNull var notId:Int,
                  @ColumnInfo(name = "not_baslik") @NotNull var notBaslik:String,
                  @ColumnInfo(name = "not_aciklama") @NotNull var notAciklama:String):Serializable {
}