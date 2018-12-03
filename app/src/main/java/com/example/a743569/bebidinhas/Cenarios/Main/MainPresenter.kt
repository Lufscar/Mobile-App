package com.example.a743569.bebidinhas.Cenarios.Main

import com.example.a743569.bebidinhas.Retrofit.RetrofitInicializer

class MainPresenter (val view: MainContract.View) : MainContract.Presenter{
    fun onLoadBebidas(){
        val bebidinhasService = RetrofitInicializer().createBebidinhasService()

        val call = bebidinhasService.getBebidinhasAcoolicas()

        call.enqueue()
    }

}