package com.example.a743569.bebidinhas.Retrofit

import retrofit2.Call
import com.example.a743569.bebidinhas.Entidades.ListaBebidinhas
import retrofit2.http.GET
import retrofit2.http.Query

//facilita a chamada a API
interface BebidinhasService {
    companion object {
        private const val API_CHAVE = "apiKey=1"
    }

    //drinks alcolicos
    @GET("filter.php?a=Alcoholic&$API_CHAVE")
    fun getBebidinhasAlcoolicas(): Call<ListaBebidinhas>

    //drink aleatório
    @GET("random.php?$API_CHAVE")
    fun getRandBebidinha(): Call<ListaBebidinhas>

    //drink por id
    @GET("lookup.php?$API_CHAVE")
    fun getIDbebidinha(@Query("i") id : String): Call<ListaBebidinhas>

}