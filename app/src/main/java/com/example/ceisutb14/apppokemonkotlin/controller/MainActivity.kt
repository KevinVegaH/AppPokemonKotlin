package com.example.ceisutb14.apppokemonkotlin.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ceisutb14.apppokemonkotlin.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_vs_bot.setOnClickListener{

            val boton_vs = Intent(this, VsActivity::class.java)
            startActivity(boton_vs)

        }


    }




}
