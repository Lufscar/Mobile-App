package com.example.a743569.bebidinhas.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//chama os dados da API
class RetrofitInicializer{

        val retrofit = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())             //converte o Json para um objeto em kotlin
        .build()

        fun createBebidinhasService():BebidinhasService = retrofit.create(BebidinhasService::class.java)

}