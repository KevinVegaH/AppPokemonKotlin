package com.example.ceisutb14.apppokemonkotlin.controller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.AutoCompleteTextView
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

class VsActivity : AppCompatActivity() {

     private val pk = Pokemon()
     private lateinit var textViewMessage: TextView
     private  lateinit var  btnBattle: Button
     var contexto: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        selec_poke.setOnClickListener{

            btnBattle = findViewById(R.id.btn_pelea)
            btnBattle.isClickable = false
            btnBattle.visibility = View.VISIBLE


            val pokePut = (Math.random() * 500).toInt()

            val url = "https://pokeapi.co/api/v2/pokemon/" + pokePut

            getJson(url)


        }




    }
    fun getJson(url: String) {
        val jsObjRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            //enviando JSON a la clase pokemon y devolviendo un informacion.

            textViewMessage = findViewById(R.id.pokeName)


            val name = pk.getName(response)
            val image = pk.getImage_Front(response)
            textViewMessage.text = "$name"
            Glide.with(contexto).load(image).into(pokeImage)
            println("¡¡HERE!! : " +image)

        }, Response.ErrorListener {
            // TODO Auto-generated method stub
        })


        // Access the RequestQueue through your singleton class.
        VolleySingleton.instance?.addToRequestQueue(jsObjRequest)
    }


}
