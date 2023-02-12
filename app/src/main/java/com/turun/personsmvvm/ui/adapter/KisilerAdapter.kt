package com.turun.personsmvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.turun.personsmvvm.R
import com.turun.personsmvvm.data.entity.Kisiler
import com.turun.personsmvvm.databinding.CardTasarimBinding
import com.turun.personsmvvm.databinding.FragmentAnaSayfaBinding
import com.turun.personsmvvm.ui.fragment.AnaSayfaFragmentDirections
import com.turun.personsmvvm.ui.viewmodel.AnasayfaViewModel
import com.turun.personsmvvm.util.gecisYapN

class KisilerAdapter(var mContext: Context,

                     var kisilerListesi:List<Kisiler>,
                     var viewModel: AnasayfaViewModel):
RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

    inner class  CardTasarimTutucu(tasarim:CardTasarimBinding):RecyclerView.ViewHolder(
        tasarim.root){
        var tasarim:CardTasarimBinding

        init {
            this.tasarim=tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //viewBinding tasarımı
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding=DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim,
        parent,false)

        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //işlemler
        val kisi= kisilerListesi.get(position)

         val t= holder.tasarim
        t.kisiNesnesiCard=kisi


        t.satirCard.setOnClickListener {
            val gecis= AnaSayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecisYapN(it,gecis)

        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(kisi.kisi_id)//ilgili pozisyondaki id gönderdik
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }


    
}