package com.example.a743569.bebidinhas.Cenarios.Main

import android.content.Context
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.Entidades.ListaBebidinhas

interface MainContract {
    interface  View{
        fun showMessage(msg:String)
        fun showList(bebidinhas: List<Bebidinha>)
        fun showLoading()
        fun hideLoading()
        fun showDetails(bebidinha: Bebidinha)

    }

    interface Presenter{
        fun onLoadBebidas(context: Context)
        fun onLoadRandom()

    }
}