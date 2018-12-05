package com.example.a743569.bebidinhas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.a743569.bebidinhas.Cenarios.Main.MainList_Activity
import com.example.a743569.bebidinhas.Glide.GlideApp
import kotlinx.android.synthetic.main.activity_splash_screen_.*

class SplashScreen_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_)

        GlideApp.with(this)
                .load("https://cdn.dribbble.com/users/35243/screenshots/2663562/drink.gif")
                .centerCrop()
                .placeholder(R.drawable.drink)
               // .into(ivImagemSplash)
        Handler().postDelayed({
            val telaPrincipal = Intent(this, MainList_Activity::class.java)
            startActivity(telaPrincipal)
            finish()
        }, 2000)
    }
}
