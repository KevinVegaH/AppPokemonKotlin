package com.example.ceisutb14.apppokemonkotlin.controller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ceisutb14.apppokemonkotlin.R
import com.example.ceisutb14.apppokemonkotlin.model.Pokemon
import com.example.ceisutb14.apppokemonkotlin.model.VolleySingleton
import kotlinx.android.synthetic.main.activity_main2.*
import com.bumptech.glide.Glide;
import com.example.ceisutb14.apppokemonkotlin.R.layout.activity_main2
import android.content.Intent
import com.example.ceisutb14.apppokemonkotlin.model.PokeData


class VsActivity : AppCompatActivity() {

     private val pk = Pokemon()
     private  val pkd = PokeData()
     private val pk2 = PokeData()
     private lateinit var textViewMessage: TextView
     private  lateinit var  btnBattle: Button
     private var contexto: Context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main2)


        selec_poke.setOnClickListener{

            val poke = (Math.random() * 500).toInt()
            val poke2 = (Math.random() * 500).toInt()

            val url = "https://pokeapi.co/api/v2/pokemon/" + poke
            val url2 = "https://pokeapi.co/api/v2/pokemon/" + poke2

            getJson(url)
            getJson2(url2)

        }

        btn_pelea.setOnClickListener{


            val fight = Intent(this,FightActivity::class.java)


            // Pokemon Player //
            fight.putExtra("Poke_name", pkd.name)
            fight.putExtra("Img_Front", pkd.img_front)
            fight.putExtra("Img_Back", pkd.img_back)

            // Pokemon Enemy //
            fight.putExtra("Poke_name2", pk2.name)
            fight.putExtra("Img_Front2", pk2.img_front)
            fight.putExtra("Img_Back2", pk2.img_back)

            startActivity(fight)

            //println("Here Get!!!: "+pkd.name)
        }




    }
    fun getJson(url: String) {
        val jsObjRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            //enviando JSON a la clase pokemon y devolviendo un informacion.

            textViewMessage = findViewById(R.id.pokeName)

            btnBattle = findViewById(R.id.btn_pelea)
            //btnBattle.isClickable = false
            btnBattle.visibility = View.VISIBLE


            val name = pk.getName(response)
            val image = pk.getImage_Front(response)
            val imageBack = pk.getImage_Back(response)

            pkd.name = name
            pkd.img_front = image.toString()
            pkd.img_back = imageBack.toString()

            textViewMessage.text = "$name"
            Glide.with(contexto).load(image).into(pokeImage)

            println("¡¡HERE!! : " +imageBack)

        }, Response.ErrorListener {
            // TODO Auto-generated method stub
        })


        // Access the RequestQueue through your singleton class.
        VolleySingleton.instance?.addToRequestQueue(jsObjRequest)
    }

    fun getJson2(url: String) {
        val jsObjRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            //enviando JSON a la clase pokemon y devolviendo un informacion.

            textViewMessage = findViewById(R.id.pokeName)

            val name = pk.getName(response)
            val image = pk.getImage_Front(response)
            val imageBack = pk.getImage_Back(response)

            pk2.name = name
            pk2.img_front = image.toString()
            pk2.img_back = imageBack.toString()

            println("¡¡HERE2!! : " +imageBack)

        }, Response.ErrorListener {
            // TODO Auto-generated method stub
        })


        // Access the RequestQueue through your singleton class.
        VolleySingleton.instance?.addToRequestQueue(jsObjRequest)
    }


}
