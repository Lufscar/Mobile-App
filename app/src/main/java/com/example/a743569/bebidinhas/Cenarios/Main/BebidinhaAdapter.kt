package com.example.a743569.bebidinhas.Cenarios.Main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.R
import kotlinx.android.synthetic.main.item_da_lista.view.*

class BebidinhaAdapter(val bebidinhas: List<Bebidinha>)
    : RecyclerView.Adapter<BebidinhaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_da_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bebidinhas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(bebidinhas[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(bebidinhaNome: Bebidinha) {
            itemView.tvNome.text = bebidinhaNome.strDrink
            itemView.
        }

    }
}