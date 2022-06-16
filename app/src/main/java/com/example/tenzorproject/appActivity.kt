package com.example.tenzorproject

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.tenzorproject.databinding.ActivityAppBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject


class appActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        var editText = findViewById<View>(R.id.pokeName) as EditText
        binding.get.setOnClickListener{
            getPokemon(editText.text)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.myPoke ->{
                val app_intent = Intent(this, PokemonList::class.java)
                startActivity(app_intent)
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_tool, menu)
        return true
    }
    private fun getPokemon(name: Editable){
        val url = "https://pokeapi.co/api/v2/pokemon/$name"
        val queue = Volley.newRequestQueue(this)
        val name_text = findViewById<TextView>(R.id.name)
        val weight_text = findViewById<TextView>(R.id.weight)
        val im = findViewById<ImageView>(R.id.imagePoke)
        val request = StringRequest(Request.Method.GET, url, {
                response ->
                val res = JSONObject(response)
                val weight = res.getInt("weight")
                val forms = res.getJSONArray("forms")
                val sprites = res.getJSONObject("sprites")

                val nameForm = forms.getJSONObject(0)

                Picasso.get().load(sprites["front_default"].toString()).into(im)
                name_text.text = nameForm["name"].toString()
                weight_text.text = "Weight: ${weight.toString()}"

                val poke = Toast.makeText(this,  "You found a pokemon!",Toast.LENGTH_LONG)
                poke.show()
        }, {})
        queue.add(request)
        return
    }
}