package com.example.ceisutb14.apppokemonkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_vs.setOnClickListener{

            val boton_vs = Intent(this,Main2Activity::class.java)
            startActivity(boton_vs)

        }


    }
}
