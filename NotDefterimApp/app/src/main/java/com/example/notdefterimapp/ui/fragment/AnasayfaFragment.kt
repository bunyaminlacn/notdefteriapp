package com.example.notdefterimapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notdefterimapp.R
import com.example.notdefterimapp.data.entiti.Notlar
import com.example.notdefterimapp.databinding.FragmentAnasayfaBinding
import com.example.notdefterimapp.ui.adapter.NotlarAdapter
import com.example.notdefterimapp.ui.viewmodel.AnasayfaViwModel
import com.example.notdefterimapp.ui.viewmodel.NotEkleViwModel
import com.example.notdefterimapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewmodel:AnasayfaViwModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anasayfaFragment=this
        binding.anasayfaToolbarBaslik="NOTLARIM"

        viewmodel.notlarListesi.observe(viewLifecycleOwner){
            val notlarAdapter=NotlarAdapter(requireContext(), it as ArrayList<Notlar>,viewmodel)
            binding.notAdapter=notlarAdapter
        }






        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewmodel.ara(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                viewmodel.ara(query)
                return true
            }
        })




        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViwModel by viewModels()
        viewmodel=tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.a_to_ekle)

    }

    override fun onResume() {
        super.onResume()
        viewmodel.notlariYukle()

    }


}