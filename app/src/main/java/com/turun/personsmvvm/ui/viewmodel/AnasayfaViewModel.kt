package com.turun.personsmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.turun.personsmvvm.data.entity.Kisiler
import com.turun.personsmvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor(var krepo:KisilerDaoRepository):ViewModel() {

   // val krepo= KisilerDaoRepository()

    var kisilerListesi= MutableLiveData<List<Kisiler>>() //livedata

    init {
        kisileriYukle()

        kisilerListesi=krepo.kisileriGetir()
    }
    

    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id:Int){
        krepo.kisiSil(kisi_id)
        //id buraya geldi burdan repoya gitti
    }

    fun kisileriYukle(){

        krepo.tumKisileriAl()
    }


}