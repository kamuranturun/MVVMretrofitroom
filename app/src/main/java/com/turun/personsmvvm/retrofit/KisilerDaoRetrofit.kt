package com.turun.personsmvvm.retrofit


import com.turun.personsmvvm.data.entity.KisilerCevap
import retrofit2.Call
import retrofit2.http.GET

interface KisilerDaoRetrofit {

    @GET("kisiler/tum_kisiler.php")
    fun tumKisilerRetrofit(): Call<KisilerCevap>
}