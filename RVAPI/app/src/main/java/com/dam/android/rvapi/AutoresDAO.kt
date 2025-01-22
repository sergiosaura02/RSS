package com.dam.android.rvapi

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AutoresDAO {
    @Query ("Select * from autores")
    fun selectAll():List<Autores>

    @Insert
    fun insert(autor:Autores):Long

    @Delete
    fun delete(autor: Autores)
}