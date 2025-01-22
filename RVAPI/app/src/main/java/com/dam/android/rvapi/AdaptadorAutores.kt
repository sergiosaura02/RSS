package com.dam.android.rvapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorAutores : RecyclerView.Adapter<AutoresViewHolder>() {
    private var aut: List<Autores> = ArrayList()
    private lateinit var listener: AdaptadorCallback
    interface AdaptadorCallback {
        fun onSafeAutor(autor: Autores)
    }
    fun setAdaptadorCallback(listener: AdaptadorCallback) {
        this.listener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoresViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var viewHolder = AutoresViewHolder(layoutInflater.inflate(R.layout.fila_autores, parent, false))
        viewHolder.toolbarAutores.inflateMenu(R.menu.toolbar_autores)
        return viewHolder
    }

    override fun getItemCount(): Int = aut.size
    override fun onBindViewHolder(holder: AutoresViewHolder, position: Int) {
        val item = aut[position]
        holder.nombre.text = item.name
        holder.toolbarAutores.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_guardar -> {
                    //guardar en BBDD
                    listener.onSafeAutor(item)
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
