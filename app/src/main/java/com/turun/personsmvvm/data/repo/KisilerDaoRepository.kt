package com.turun.personsmvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.turun.personsmvvm.data.entity.Kisiler
import com.turun.personsmvvm.data.entity.KisilerCevap
import com.turun.personsmvvm.retrofit.KisilerDaoRetrofit
import com.turun.personsmvvm.room.KisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaoRepository(//var kdao:KisilerDao,
                           var kdao:KisilerDaoRetrofit
    ) {

    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi=MutableLiveData()
    }


    fun kisileriGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }

    fun kisiKayit(kisi_ad:String,kisi_tel:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi= Kisiler(0,kisi_ad,kisi_tel)
          //  kdao.kisiEkle(yeniKisi)
        }
    }

//ortak alan burası
    //2
    fun kisiGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
    val job= CoroutineScope(Dispatchers.Main).launch {
        val guncellenenKisi= Kisiler(kisi_id,kisi_ad,kisi_tel)
      //  kdao.kisiGuncelle(guncellenenKisi)
    }
    }


    fun kisiAra(aramaKelimesi:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
          //  kisilerListesi.value=kdao.kisiArama(aramaKelimesi)
        }
    }


    fun kisiSil(kisi_id: Int){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi= Kisiler(kisi_id,"","")
           // kdao.kisiSil(silinenKisi)

            tumKisileriAl()

    }
    }

    //bundan sonrası live data

     fun tumKisileriAl(){

        /*
        val job= CoroutineScope(Dispatchers.Main).launch {
           // kisilerListesi.value=kdao.tumKisiler()
        }
         */




         kdao.tumKisilerRetrofit().enqueue(object : Callback<KisilerCevap?> {
             override fun onResponse(call: Call<KisilerCevap?>, response: Response<KisilerCevap?>) {
                 val liste=response.body()?.kisiler
                 kisilerListesi.value=liste!!
             }

             override fun onFailure(call: Call<KisilerCevap?>, t: Throwable) {

                 println(t.message)
             }
         })





    }
}