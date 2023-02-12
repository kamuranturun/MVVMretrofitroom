package com.turun.personsmvvm.retrofit

class ApiUtils {

    companion object{

        val BASE_URL= "http://kasimadalan.pe.hu/"

        fun getKisilerDao():KisilerDaoRetrofit{
            return RetrofitClient.getClient(BASE_URL)
                .create(KisilerDaoRetrofit::class.java)
        }
    }
}