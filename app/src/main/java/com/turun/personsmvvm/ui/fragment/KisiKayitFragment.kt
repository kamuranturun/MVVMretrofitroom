package com.turun.personsmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.turun.personsmvvm.R
import com.turun.personsmvvm.databinding.FragmentKisiKayitBinding
import com.turun.personsmvvm.ui.viewmodel.KisiDetayViewModel
import com.turun.personsmvvm.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiKayitFragment : Fragment() {

    private lateinit var tasarim:FragmentKisiKayitBinding

    private lateinit var viewModel: KisiKayitViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)//dataBinding kurulumu

        tasarim.kisiKayitToolbarBaslik="Kişi Kayit"
        tasarim.kisiKayitFragment=this //yetki verdik



        return tasarim.root
        ///
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //kisiKayitViewModel bağlama
        val tempViewModel:  KisiKayitViewModel by viewModels()
        viewModel=tempViewModel
    }



    fun buttonKaydet(kisi_ad:String, kisi_tel:String){

        viewModel.kayit(kisi_ad,kisi_tel)

        //bu fonksiyon calışınca
        // xml deki bu satir     android:onClick="@{()->kisiKayitFragment.buttonKaydet(editTextKisiAd.getText().toString(),editTextKisiTel.getText().toString())}"
        //calışır
    }

}