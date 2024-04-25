package com.example.notdefterimapp.di

import android.content.Context
import androidx.room.Room
import com.example.notdefterimapp.data.datasource.NotlarDatasource
import com.example.notdefterimapp.data.repo.NotlarRepository
import com.example.notdefterimapp.room.NotlarDao
import com.example.notdefterimapp.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    @Singleton
    fun provideNotlarDataSource (ndao:NotlarDao):NotlarDatasource {

        return NotlarDatasource(ndao)
    }

    @Provides
    @Singleton
    fun provideNotlarRepository (nds:NotlarDatasource): NotlarRepository {

        return NotlarRepository(nds)
    }

    @Provides
    @Singleton
    fun provideNotlarDao (@ApplicationContext context:Context): NotlarDao {

        val vt =Room.databaseBuilder(context,
            VeriTabani::class.java,"notlarvt.sqlite").createFromAsset("notlarvt.sqlite").build()

        return vt.getNotlarDao()
    }
}