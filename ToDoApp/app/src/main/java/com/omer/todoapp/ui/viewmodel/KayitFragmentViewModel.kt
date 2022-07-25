package com.omer.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.omer.todoapp.data.repo.YapilacaklarDaoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class KayitFragmentViewModel @Inject constructor(var yrepo: YapilacaklarDaoRepo):ViewModel(){

    fun kayit(yapilacak_is:String){
        yrepo.yapilacakKayit(yapilacak_is)
    }


}