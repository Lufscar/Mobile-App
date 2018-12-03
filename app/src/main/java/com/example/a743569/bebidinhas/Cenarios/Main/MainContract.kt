package com.example.a743569.bebidinhas.Cenarios.Main

interface MainContract {
    interface  View{
        fun showMessage(msg: String)
        fun showList(bebidinhas: List<Bebidinha>)

    }

    interface Presenter{

    }
}