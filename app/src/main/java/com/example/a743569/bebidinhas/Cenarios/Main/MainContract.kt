package com.example.a743569.bebidinhas.Cenarios.Main

import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.Entidades.ListaBebidinhas

interface MainContract {
    interface  View{
        fun showMessage(msg:String)
        fun showList(bebidinhas: List<Bebidinha>)
        fun showLoading()
        fun hideLoading()

    }

    interface Presenter{
        fun onLoadBebidas()

    }
}