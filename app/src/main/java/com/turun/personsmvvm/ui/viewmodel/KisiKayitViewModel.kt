package com.turun.personsmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.turun.personsmvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor(var krepo:KisilerDaoRepository):ViewModel() {

   // val krepo= KisilerDaoRepository()

    fun kayit(kis_ad:String,kisi_tel:String){

        krepo.kisiKayit(kis_ad,kisi_tel)

    }
}