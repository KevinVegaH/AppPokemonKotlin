package com.example.ceisutb14.apppokemonkotlin.controller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ceisutb14.apppokemonkotlin.R
import kotlinx.android.synthetic.main.activity_fight.*
import kotlinx.android.synthetic.main.activity_main2.*

class FightActivity : AppCompatActivity() {

    var contexto: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fight)

        var poke_name = intent.extras.getString("Poke_name")
        var poke_img_front = intent.extras.getString("Img_Front")
        var poke_img_back = intent.extras.getString("Img_Back")

        var poke_name2 = intent.extras.getString("Poke_name2")
        var poke_img_front2 = intent.extras.getString("Img_Front2")
        var poke_img_back2 = intent.extras.getString("Img_Back2")

        Glide.with(contexto).load(poke_img_front2).into(pokemonEnemy)
        Glide.with(contexto).load(poke_img_back).into(pokemonPlay)

        //println("Here in new View!: "+ poke_img_front)


    }
}
