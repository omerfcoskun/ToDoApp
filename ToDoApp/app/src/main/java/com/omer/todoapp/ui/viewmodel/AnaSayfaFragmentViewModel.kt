package com.omer.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omer.todoapp.data.entity.Yapilacaklar
import com.omer.todoapp.data.repo.YapilacaklarDaoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnaSayfaFragmentViewModel @Inject constructor(var yrepo:YapilacaklarDaoRepo) :ViewModel() {

    var yapliste=MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacakYukle()
        yapliste =yrepo.yapilacaklarGetir()

    }
    fun yapilacakYukle(){
        yrepo.tumYapilacakGetir()
    }
    fun ara(aramaKelimesi:String){
        yrepo.yapilacakAra(aramaKelimesi)
    }
    fun sil(yapilacak_id:Int){
        yrepo.yapilacakSil(yapilacak_id)
    }
}