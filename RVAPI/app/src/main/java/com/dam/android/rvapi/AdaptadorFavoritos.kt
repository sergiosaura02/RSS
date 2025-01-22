package com.dam.android.rvapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorFavoritos : RecyclerView.Adapter<AutoresViewHolder>() {
    private var aut: List<Autores> = ArrayList()
    private lateinit var listener: AdaptadorCallback
    interface AdaptadorCallback {
        fun onDeleteFavorito(autor: Autores)
    }
    fun setAdaptadorCallback(listener: AdaptadorCallback) {
        this.listener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoresViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var viewHolder = AutoresViewHolder(layoutInflater.inflate(R.layout.fila_autores, parent, false))
        viewHolder.toolbarAutores.inflateMenu(R.menu.toolbar_favoritos)
        return viewHolder
    }

    override fun getItemCount(): Int = aut.size
    override fun onBindViewHolder(holder: AutoresViewHolder, position: Int) {
        val item = aut[position]
        holder.nombre.text = item.name
        holder.toolbarAutores.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_eliminar -> {
                    //borrar en BBDD
                    listener.onDeleteFavorito(item)
                    true
                }
                else ->{
                    true
                }
            }
        }
    }

    fun changelist(autores: List<Autores>) {
        aut=autores
    }
}
