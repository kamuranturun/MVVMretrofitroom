package com.turun.personsmvvm.di

import android.content.Context
import androidx.room.Room
import com.turun.personsmvvm.data.repo.KisilerDaoRepository
import com.turun.personsmvvm.retrofit.ApiUtils
import com.turun.personsmvvm.retrofit.KisilerDaoRetrofit
import com.turun.personsmvvm.room.KisilerDao
import com.turun.personsmvvm.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    /*
    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kdao:KisilerDao):KisilerDaoRepository{
        return KisilerDaoRepository(kdao)
    }
     */

    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kdao:KisilerDaoRetrofit):KisilerDaoRepository{
        return KisilerDaoRepository(kdao)
    }



    @Provides
    @Singleton
    fun provideKisilerDaoRetrofit():KisilerDaoRetrofit{
        return ApiUtils.getKisilerDao()
    }



  /*
    @Provides
    @Singleton
    fun providesKisilerDao(@ApplicationContext context: Context):KisilerDao{

        val vt= Room.databaseBuilder(context,VeriTabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite").build() //kopyalama
        return vt.getKisilerDao()
    }
   */
}