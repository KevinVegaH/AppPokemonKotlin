package com.example.ceisutb14.apppokemonkotlin.model

import android.R.attr.name
import org.json.JSONException
import org.json.JSONObject
import android.R.attr.data





/**
 * Created by kevin_000 on 25/02/2018.
 */
class Pokemon {

    private var name: String? = null
    private var front_default_url: String? = null
    private var info_Sprites: JSONObject? = null

    private var image: JSONObject? = null

    fun getName(info: JSONObject): String {
        try {
            name = info.getString("name").toString()
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return name.toString()
    }

    private fun getSprites(info: JSONObject): JSONObject? {
        info_Sprites = null
        try {
            info_Sprites = info.getJSONObject("sprites")
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return info_Sprites
    }

    fun getImage_Front(info: JSONObject): String? {

        var pkm= Pokemon()
        image = pkm.getSprites(info)

        try {

            front_default_url = image!!.getString("front_default")


        } catch (e: JSONException) {

            e.printStackTrace()

        }

        return front_default_url
    }

}