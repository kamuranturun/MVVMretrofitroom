package com.turun.personsmvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.turun.personsmvvm.R

fun Navigation.gecisYap(it:View,id:Int){

    findNavController(it).navigate(id)

}

fun Navigation.gecisYapN(it:View,id:NavDirections){

    findNavController(it).navigate(id)

}