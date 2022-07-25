package com.omer.todoapp.di

import android.content.Context
import androidx.room.Room
import com.omer.todoapp.data.repo.YapilacaklarDaoRepo
import com.omer.todoapp.room.Veritabani
import com.omer.todoapp.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarDaoRepo(ydao:YapilacaklarDao):YapilacaklarDaoRepo{
        return YapilacaklarDaoRepo(ydao)
    }
    @Provides
    @Singleton

    fun provideYapilacakDao(@ApplicationContext context:Context):YapilacaklarDao{
        val vt=Room.databaseBuilder(context,Veritabani::class.java,"yapilacaklar.sqlite").createFromAsset("yapilacaklar.sqlite")
            .build()
        return vt.getYapilacaklarDao()
    }


}