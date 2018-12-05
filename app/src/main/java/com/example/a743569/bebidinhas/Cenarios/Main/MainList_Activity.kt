package com.example.a743569.bebidinhas.Cenarios.Main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import com.example.a743569.bebidinhas.Cenarios.Detalhes.Detalhes_Activity
import com.example.a743569.bebidinhas.Entidades.Bebidinha
import com.example.a743569.bebidinhas.R
import kotlinx.android.synthetic.main.activity_main.*

class MainList_Activity : AppCompatActivity() , MainContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter( this)
        presenter.onLoadBebidas(this)
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

        //clique para os detalhes
        adapter.setOnItenClickListener {indexItemClicado ->
            val editaItem = Intent(this, Detalhes_Activity::class.java)
            editaItem.putExtra(Detalhes_Activity.BEBIDINHA, bebidinhas[indexItemClicado])
            startActivity(editaItem)
        }


        //Toast.makeText(this, "Bebidinhas Recebidas", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_random -> {
                val presenter : MainContract.Presenter = MainPresenter( this)
                presenter.onLoadRandom()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showDetails(bebidinha: Bebidinha) {
        val editaItem = Intent(this, Detalhes_Activity::class.java)
        editaItem.putExtra(Detalhes_Activity.BEBIDINHA, bebidinha)
        startActivity(editaItem)
    }

}
