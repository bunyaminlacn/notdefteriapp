package com.example.notdefterimapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.notdefterimapp.R
import com.example.notdefterimapp.databinding.FragmentNotGuncelleBinding
import com.example.notdefterimapp.ui.viewmodel.NotEkleViwModel
import com.example.notdefterimapp.ui.viewmodel.NotGuncelleViwModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotGuncelleFragment : Fragment() {
    private lateinit var binding: FragmentNotGuncelleBinding
    private lateinit var viewmodel: NotGuncelleViwModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_not_guncelle, container, false)
        binding.notGuncelleFragment=this
        binding.notGuncelleToolbarBaslik = "Not Detay"

        val bundle: NotGuncelleFragmentArgs by navArgs()
        val gelenNotlar=bundle.notlar
        binding.notNesnesi=gelenNotlar


        return binding.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NotGuncelleViwModel by viewModels()
        viewmodel=tempViewModel
    }
    fun buttonNotGuncelle(notId:Int,not_baslik:String,not_Aciklama:String){

        viewmodel.buttonNotGuncelle(notId,not_baslik,not_Aciklama)

    }

}