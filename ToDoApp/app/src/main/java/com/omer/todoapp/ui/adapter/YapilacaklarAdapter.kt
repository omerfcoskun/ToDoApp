package com.omer.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.omer.todoapp.R
import com.omer.todoapp.data.entity.Yapilacaklar
import com.omer.todoapp.databinding.CardTasarimBinding
import com.omer.todoapp.ui.fragment.AnaSayfaFragmentDirections
import com.omer.todoapp.ui.viewmodel.AnaSayfaFragmentViewModel
import com.omer.todoapp.util.gecisYap



class YapilacaklarAdapter (var mContext: Context,var yapilacaklarListesi:List<Yapilacaklar>,var viewModel: AnaSayfaFragmentViewModel)
    :RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>(){


    inner class CardTasarimTutucu(tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim=tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater =LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding =DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }




    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi[position]
        val t =holder.tasarim

        t.yapilacakNesnesi =yapilacak
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_is} silinsin mi?",Snackbar.LENGTH_SHORT).setAction("EVET"){
                viewModel.sil(yapilacak.yapilacak_id)
            }
                .show()
        }


        t.satirCard.setOnClickListener {
            val gecis=AnaSayfaFragmentDirections.detayGecis(yapilacak=yapilacak)
            Navigation.gecisYap(it,gecis)
        }

    }
    override fun getItemCount(): Int {
        return yapilacaklarListesi.size

    }
}