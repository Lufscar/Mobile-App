package com.example.a743569.bebidinhas.Cenarios.Detalhes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.Glide.GlideApp
import com.example.a743569.bebidinhas.R
import kotlinx.android.synthetic.main.activity_detalhes_.*

class Detalhes_Activity : AppCompatActivity(), DetalhesContract.View {
    override fun showLoading() {
        pbloadingDetalhes.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbloadingDetalhes.visibility = ProgressBar.GONE
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    companion object {
        public const val BEBIDINHA: String = "Bebidinha"
        var bebidinha: Bebidinha?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_)

        val presenter = DetailsPresenter(this)

        bebidinha = intent.getSerializableExtra(BEBIDINHA) as Bebidinha?
        if(bebidinha != null){
            presenter.carregaDados(bebidinha!!.idDrink)
        }
    }

    //mostra os dados de acordo com a url de cada id
    override fun mostraDados(bebidinha: Bebidinha) {

        GlideApp.with(this)
                .load(bebidinha.strDrinkThumb)
                .centerCrop()
                .into(ivImagemDetalhe)

        tv_nomeDetalhe.text= bebidinha.strDrink
        tv_idDetalhe.text= bebidinha.idDrink.toString()
        tv_InstructionsDetalhes.text= bebidinha.strInstructions
        tv_categoriaDetalhe.text= bebidinha.strCategory

    }
}
