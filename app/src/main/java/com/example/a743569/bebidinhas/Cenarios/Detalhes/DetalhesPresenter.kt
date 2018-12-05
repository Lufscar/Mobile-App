package com.example.a743569.bebidinhas.Cenarios.Detalhes

import android.content.Context
import com.example.a743569.bebidinhas.Entidades.ListaBebidinhas
import com.example.a743569.bebidinhas.Retrofit.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//idem MainPresenter
class DetailsPresenter(val view: DetalhesContract.View) : DetalhesContract.Presenter {
    override fun carregaDados(idDrink: Int) {
        view.showLoading()

        val bebidinhasService = RetrofitInicializer().createBebidinhasService() //inicia o retrofit

        val call = bebidinhasService.getIDbebidinha(idDrink.toString())//forma assincrona

        call.enqueue(object : Callback<ListaBebidinhas> {                           //acesso a url
            override fun onFailure(call: Call<ListaBebidinhas>?, t: Throwable?) {           //se
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")         //exibe msg de erro
            }

            override fun onResponse(call: Call<ListaBebidinhas>?, response: Response<ListaBebidinhas>?) {   //se não falhar
                view.hideLoading()
                if (response?.body() != null){                                                               //se a url retornar algum dado
                    view.mostraDados(response.body()!!.drinks[0])                                            //mostra a lista bebidinhas
                }else{                                                                                 //se não retornar nenhum dado
                    view.showMessage("Não há bebidinhas na sua lista :(")                              //exibe mensagem
                }
            }

        })
    }
}