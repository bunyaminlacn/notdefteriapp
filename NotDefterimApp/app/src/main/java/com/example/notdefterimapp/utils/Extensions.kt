package com.example.notdefterimapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.notdefterimapp.R

fun Navigation.gecisYap(it:View,Id:Int){
   findNavController(it).navigate(Id)

}
fun Navigation.gecisYap(it:View,Id:NavDirections){
   findNavController(it).navigate(Id)

}

