package com.angoti.projetointegrador4_2020.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.angoti.projetointegrador4_2020.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_alterar -> {
                startActivity(Intent(this, AlteracaoDeUsuarioActivity::class.java))
                true
            }
            R.id.action_login -> {
                startActivity(Intent(this, LoginActivity::class.java))
                true
            }
            R.id.action_novo -> {
                startActivity(Intent(this, CadastroDeUsuarioActivity::class.java))
                true
            }
            R.id.action_todos -> {
                startActivity(Intent(this, ListagemDeUsuariosActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}