package com.example.a743569.bebidinhas.Cenarios.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.a743569.bebidinhas.R

class MainActivity : AppCompatActivity() , MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
