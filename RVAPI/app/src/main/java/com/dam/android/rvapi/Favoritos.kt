package com.dam.android.rvapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Favoritos : AppCompatActivity() {
    private lateinit var recyclerViewFavoritos: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favoritos)

        //bind
        recyclerViewFavoritos=findViewById(R.id.rvFavoritos)
        val adaptadorFavoritos=AdaptadorFavoritos()

        recyclerViewFavoritos.layoutManager=LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false)
        recyclerViewFavoritos.adapter=adaptadorFavoritos

        //Hacer que funcione eliminar
        var datosFavoritos:MutableList<Autores>
        adaptadorFavoritos.setAdaptadorCallback(object:AdaptadorFavoritos.AdaptadorCallback{
            override fun onDeleteFavorito(autor: Autores) {
                lifecycleScope.launch(Dispatchers.IO) {
                    val database=AutoresBBDD.getInstance(applicationContext)
                    database.autoresDAO().delete(autor)
                    datosFavoritos=database.autoresDAO().selectAll() as MutableList<Autores>
                    withContext(Dispatchers.Main) {
                        adaptadorFavoritos.changelist(datosFavoritos)
                        adaptadorFavoritos.notifyDataSetChanged()
                    }
                }
            }

        })

        lifecycleScope.launch(Dispatchers.IO) {
            val database=AutoresBBDD.getInstance(applicationContext)
            datosFavoritos=database.autoresDAO().selectAll() as MutableList<Autores>
            withContext(Dispatchers.Main) {
                adaptadorFavoritos.changelist(datosFavoritos)
                adaptadorFavoritos.notifyDataSetChanged()
            }
        }
    }
}