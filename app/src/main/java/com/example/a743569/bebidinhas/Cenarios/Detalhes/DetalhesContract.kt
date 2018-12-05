package com.example.a743569.bebidinhas.Cenarios.Detalhes

import com.example.a743569.bebidinhas.Entidades.Bebidinha

/**
 * Created by 743569 on 05/12/18.
 */
interface DetalhesContract {
    interface View{
        fun mostraDados(bebidinha: Bebidinha)
        fun showLoading()
        fun hideLoading()
        fun showMessage(msg: String)
    }

    interface Presenter{
        fun carregaDados(idDrink: Int)
    }
}