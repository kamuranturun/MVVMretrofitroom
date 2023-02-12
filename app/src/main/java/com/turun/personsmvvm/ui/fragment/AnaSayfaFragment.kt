package com.turun.personsmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.turun.personsmvvm.R
import com.turun.personsmvvm.data.entity.Kisiler
import com.turun.personsmvvm.databinding.FragmentAnaSayfaBinding
import com.turun.personsmvvm.ui.adapter.KisilerAdapter
import com.turun.personsmvvm.ui.viewmodel.AnasayfaViewModel
import com.turun.personsmvvm.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnaSayfaFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var tasarim: FragmentAnaSayfaBinding

    private lateinit var viewModel: AnasayfaViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)
        tasarim.anaSayfaFragment=this //yetkilendirme




        tasarim.anaSayfaToolbarBaslik="Kişiler"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnaSayfa)//action bar




        //tasarim.rv.layoutManager= LinearLayoutManager(requireContext()) bunu tasarım kısmında yaptık gerek kalmadı buraya yazmaya


      viewModel.kisilerListesi.observe(viewLifecycleOwner){
          val adapter= KisilerAdapter(requireContext(),it,viewModel)
          tasarim.kisilerAdapter=adapter //kisi görmek için
      }







        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)//menu bağlandı

                val item= menu.findItem(R.id.action_ara)

                val searchView= item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnaSayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)//ara yüz için

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
        //viewModellerimizi bağladık
    }

    fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.kisiKayitGecis)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        //arama ikonuna basınca calısacak
        viewModel.ara(query)

        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //klavyeden harf girişinde calısır

       viewModel.ara(newText)

        return true
    }




    override fun onResume() {
        super.onResume()

        //arayüzü güncellemede sayfa yenilenecek
        viewModel.kisileriYukle()
        Log.e("anasayfa","dönüldü")
    }

}