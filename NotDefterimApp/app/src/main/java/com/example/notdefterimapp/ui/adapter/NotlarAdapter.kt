package com.example.notdefterimapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notdefterimapp.R
import com.example.notdefterimapp.data.entiti.Notlar
import com.example.notdefterimapp.databinding.CardTasarimBinding
import com.example.notdefterimapp.ui.fragment.AnasayfaFragmentDirections
import com.example.notdefterimapp.ui.viewmodel.AnasayfaViwModel
import com.example.notdefterimapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class NotlarAdapter(var mContext: Context, var notlarListesi:ArrayList<Notlar>,var viewmodel:AnasayfaViwModel)
    :RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding:CardTasarimBinding=DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val gelenNotlar=notlarListesi.get(position)
        val t =holder.tasarim

       t.notNesnesi=gelenNotlar

        t.cardViewSatir.setOnClickListener {
           val gecis=AnasayfaFragmentDirections.aToGuncelle(gelenNotlar)
            Navigation.gecisYap(it,gecis)


        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${gelenNotlar.notId},Not Silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewmodel.sil(gelenNotlar.notId)
                }.show()
        }



    }

    override fun getItemCount(): Int {
        return notlarListesi.size
    }


}