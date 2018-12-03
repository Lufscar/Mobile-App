package com.example.a743569.bebidinhas.Cenarios.Main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.R

class MainActivity : AppCompatActivity() , MainContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val presenter : MainContract.Presenter = MainPresenter(view: this)
    presenter.onLoadBebidas()

    override fun showMessage(msg: String) {
        Toast.makeText(context: this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showList(bebidinhas: List<Bebidinha>){
        val adapter = BebidinhaAdapter(this, bebidinhas)
        adapter.setOnItemClickListener {position ->
        val openBrowser = Intent(Intent.ACTION_VIEW)
        openBrowser.data = Uri.parse(bebidinhas.get(position).url)
        startActivity(openBrowser)

        TODO("CRIAR ADAPTER (BebidinhaAdapter) - GLIDE")
        }
    }

}
