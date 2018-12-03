package com.example.a743569.bebidinhas.Cenarios.Main

import com.example.a743569.bebidinhas.Entidades.ListaBebidinhas
import com.example.a743569.bebidinhas.Retrofit.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (val view: MainContract.View) : MainContract.Presenter{

    override fun onLoadBebidas(){//conexão



        val bebidinhasService = RetrofitInicializer().createBebidinhasService()

        val call = bebidinhasService.getBebidinhasAcoolicas()//forma assincrona

        call.enqueue(object : Callback<ListaBebidinhas> {                           //acesso a url
            override fun onFailure(call: Call<ListaBebidinhas>?, t: Throwable?) {           //se falhar
                view.showMessage("Falha na conexão. Verifique o acesso a internet")         //exibe msg de erro
            }

            override fun onResponse(call: Call<ListaBebidinhas>?, response: Response<ListaBebidinhas>?) {   //se não falhar
                if (response.body() != null){                                                               //se a url retornar algum dado
                    view.showList(response.body()!!.bebidinhas)                                             //mostra a lista bebidinhas
                }else{                                                                                 //se não retornar nenhum dado
                    view.showMessage("Não há bebidinhas na sua lista :(")                              //exibe mensagem
                }
            }

        })
    }

}