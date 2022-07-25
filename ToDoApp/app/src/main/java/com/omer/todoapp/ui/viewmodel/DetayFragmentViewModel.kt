package com.omer.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.omer.todoapp.data.repo.YapilacaklarDaoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var yrepo: YapilacaklarDaoRepo):ViewModel(){

    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        yrepo.yapilacakGuncelle(yapilacak_id,yapilacak_is)
    }

}