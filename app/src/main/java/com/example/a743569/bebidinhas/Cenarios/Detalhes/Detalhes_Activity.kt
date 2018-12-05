package com.example.a743569.bebidinhas.Cenarios.Detalhes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.R
import kotlinx.android.synthetic.main.activity_detalhes_.*

class Detalhes_Activity : AppCompatActivity() {

    companion object {
        public const val BEBIDINHA: String = "Bebidinha"
        var bebidinha: Bebidinha?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_)

        bebidinha = intent.getSerializableExtra(BEBIDINHA) as Bebidinha?
        if(bebidinha != null){
            carregaDados()
        }
    }

    private fun carregaDados() {
        tv_nomeDetalhe.text= bebidinha!!.strDrink
        tv_idDetalhe.text= bebidinha!!.idDrink.toString()
        tv_InstructionsDetalhes.text= bebidinha!!.strInstructions
        tv_categoriaDetalhe.text= bebidinha!!.strCategory

    }
}
