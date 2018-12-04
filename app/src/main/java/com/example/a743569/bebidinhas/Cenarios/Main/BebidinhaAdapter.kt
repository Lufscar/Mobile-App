package com.example.a743569.bebidinhas.Cenarios.Main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.Glide.GlideApp
import com.example.a743569.bebidinhas.R
import kotlinx.android.synthetic.main.item_da_lista.view.*

class BebidinhaAdapter(val context: Context, val bebidinhas: List<Bebidinha>)
    : RecyclerView.Adapter<BebidinhaAdapter.ViewHolder>() {

    //relaciona o layout do item ao holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_da_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bebidinhas.size
    }

    //chama a fun para relacionar os dados do item à view do item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, bebidinhas[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //relaciona todos os dados do item à view do item
        fun bindView(context: Context, bebidinhaNome: Bebidinha) {
            itemView.tvNome.text = bebidinhaNome.strDrink //recebe o nome do drink

            GlideApp.with(context)
                    .load(bebidinhaNome.strDrinkThumb)//recebe a url da imagem
                    .centerCrop()//faz a imagem ocupar o espaço destinado
                    .into(itemView.ivImagem)//relaciona ao id na xml
        }

    }
}