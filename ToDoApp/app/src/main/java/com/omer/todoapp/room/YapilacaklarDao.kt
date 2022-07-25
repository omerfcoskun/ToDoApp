package com.omer.todoapp.room



import androidx.room.*
import com.omer.todoapp.data.entity.Yapilacaklar


@Dao
interface YapilacaklarDao {

    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar():List<Yapilacaklar>

    @Insert
    suspend fun yapilacakEkle(yapilacak:Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%' ")
    suspend fun yapilacakAra(aramaKelimesi:String):List<Yapilacaklar>

    @Update
    suspend fun yapilacakGuncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun yapilacakSil(yapilacak: Yapilacaklar)


}