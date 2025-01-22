package com.dam.android.rvapi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Autores (
    @PrimaryKey var key: String,
    @ColumnInfo var birth_date: String?, // ? porque acepta nulos
    @ColumnInfo var name: String) {
}