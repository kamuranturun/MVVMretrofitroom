package com.turun.personsmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.turun.personsmvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var krepo:KisilerDaoRepository):ViewModel() {

    //val krepo= KisilerDaoRepository()
//3. adım
    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        krepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
    }
}