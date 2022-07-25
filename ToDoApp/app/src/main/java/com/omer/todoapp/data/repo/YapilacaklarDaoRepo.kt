package com.omer.todoapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.omer.todoapp.data.entity.Yapilacaklar
import com.omer.todoapp.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepo(var ydao:YapilacaklarDao) {

    var yapilacaklarListesi:MutableLiveData<List<Yapilacaklar>>
    init{
        yapilacaklarListesi= MutableLiveData()
    }

    fun yapilacaklarGetir():MutableLiveData<List<Yapilacaklar>>{
        return yapilacaklarListesi
    }
    fun yapilacakKayit(yapilacak_is:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val yeni_is=Yapilacaklar(0,yapilacak_is)
            ydao.yapilacakEkle(yeni_is)
        }
    }
    fun yapilacakSil(yapilacak_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinecek =Yapilacaklar(yapilacak_id,"")
            ydao.yapilacakSil(silinecek)
            tumYapilacakGetir()
        }
    }

    fun yapilacakGuncelle(yapilacak_id:Int,yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncelleme=Yapilacaklar(yapilacak_id, yapilacak_is)
            ydao.yapilacakGuncelle(guncelleme)
        }
    }
    fun yapilacakAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value=ydao.yapilacakAra(aramaKelimesi)
        }
    }
    fun tumYapilacakGetir(){
        val job= CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value=ydao.tumYapilacaklar()
        }
    }





}