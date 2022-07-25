package com.omer.todoapp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.omer.todoapp.R
import com.omer.todoapp.databinding.FragmentAnaSayfaBinding
import com.omer.todoapp.ui.adapter.YapilacaklarAdapter
import com.omer.todoapp.ui.viewmodel.AnaSayfaFragmentViewModel
import com.omer.todoapp.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var tasarim : FragmentAnaSayfaBinding
    private lateinit var viewModel: AnaSayfaFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa,container,false)
        tasarim.anasayfaFragment=this

        tasarim.anaSayfaToolbarBaslik="Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnaSayfa)

        viewModel.yapliste.observe(viewLifecycleOwner){
            val adapter =YapilacaklarAdapter(requireContext(),it,viewModel)
            tasarim.yapilacaklarAdapter=adapter
        }


        return tasarim.root
    }
    fun fabTikla(v:View){
        Navigation.gecisYap(v,R.id.kayitGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnaSayfaFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        val item =menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)


        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacakYukle()
    }


}