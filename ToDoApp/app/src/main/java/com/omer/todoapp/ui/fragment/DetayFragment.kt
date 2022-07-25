package com.omer.todoapp.ui.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.omer.todoapp.R
import com.omer.todoapp.databinding.FragmentDetayBinding
import com.omer.todoapp.ui.viewmodel.DetayFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel:DetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)
        tasarim.detayFragment=this
        tasarim.detayToolBarBaslik="Yapılacak İş Detay"

        val bundle : DetayFragmentArgs by navArgs()

        val gelenYapilacaklar=bundle.yapilacak
        tasarim.yapilacakNesnesi=gelenYapilacaklar
        return  tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun buttonGuncelleTikla(yapilacak_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)
    }


}


