package com.example.a743569.bebidinhas.Cenarios.Main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.R
import com.example.a743569.bebidinhas.R.id.pbLoading
import kotlinx.android.synthetic.main.activity_main.*

class MainList_Activity : AppCompatActivity() , MainContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter( this)
        presenter.onLoadBebidas()
    }


    override fun showMessage(msg: String) {
        Toast.makeText( this, msg, Toast.LENGTH_LONG).show()
    }

    //mostra a lista na tela
    override fun showList(bebidinhas: List<Bebidinha>){

        //lista
        val adapter = BebidinhaAdapter(this, bebidinhas)
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)

        //recyclerview
        rvBebidas.adapter = adapter
        rvBebidas.layoutManager =LinearLayoutManager(this)
        rvBebidas.addItemDecoration(dividerItemDecoration)

        /*adapter.setOnItemClickListener {position ->
        val openBrowser = Intent(Intent.ACTION_VIEW)
        openBrowser.data = Uri.parse(bebidinhas.get(position).url)
        startActivity(openBrowser)
        }*/

        Toast.makeText(this, "Bebidinhas Recebidas", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

}
