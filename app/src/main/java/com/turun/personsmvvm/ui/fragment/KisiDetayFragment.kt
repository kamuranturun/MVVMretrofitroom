package com.turun.personsmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.turun.personsmvvm.R
import com.turun.personsmvvm.databinding.FragmentKisiDetayBinding
import com.turun.personsmvvm.ui.viewmodel.KisiDetayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentKisiDetayBinding

    private lateinit var viewModel: KisiDetayViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)

        tasarim.kisiDetayFragment=this
        tasarim.kisiDetayToolbarBaslik="Kisi Detay"

        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi= bundle.kisi

        tasarim.kisiNesnesi=gelenKisi


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiDetayViewModel by viewModels()

        viewModel=tempViewModel
    }

//1
    fun butonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){

        //4
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
    }

}