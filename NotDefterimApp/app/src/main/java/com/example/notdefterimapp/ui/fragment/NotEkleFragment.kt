package com.example.notdefterimapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.notdefterimapp.R
import com.example.notdefterimapp.databinding.FragmentNotEkleBinding
import com.example.notdefterimapp.ui.viewmodel.AnasayfaViwModel
import com.example.notdefterimapp.ui.viewmodel.NotEkleViwModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotEkleFragment : Fragment() {
    private lateinit var binding: FragmentNotEkleBinding
    private lateinit var viewmodel: NotEkleViwModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_not_ekle,container,false)
        binding.notEkleFragment=this
        binding.notEkleToolbarBaslik = "Not Kayıt"


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:NotEkleViwModel by viewModels()
        viewmodel=tempViewModel
    }
    fun buttonNotEkle(notBaslik: String,notAciklama:String){

        viewmodel.buttonNotEkle(notBaslik,notAciklama)
    }

}