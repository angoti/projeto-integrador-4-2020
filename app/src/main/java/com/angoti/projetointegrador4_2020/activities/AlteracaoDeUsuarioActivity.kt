package com.angoti.projetointegrador4_2020.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.angoti.projetointegrador4_2020.R
import com.angoti.projetointegrador4_2020.dto.UserDto
import com.angoti.projetointegrador4_2020.httpclient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlteracaoDeUsuarioActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var name: EditText
    private lateinit var phone: EditText
    private var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_de_usuario)

        email = findViewById<EditText>(R.id.et_cadastro_email)
        name = findViewById<EditText>(R.id.et_cadastro_name)
        phone = findViewById<EditText>(R.id.et_cadastro_phone)

        id = intent.getLongExtra("id", 0)
        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val cel = intent.getStringExtra("cel")

        this.email.setText(email)
        name.setText(nome)
        phone.setText(cel)

        findViewById<EditText>(R.id.et_cadastro_password).visibility = View.GONE
        //val layout = findViewById<ViewGroup>(R.id.cl_cadastro)
        //layout.removeView(findViewById(R.id.et_cadastro_password))
    }

    fun cadastrar(v: View) {
        val dtoUser = UserDto(email.text.toString(), id, name.text.toString(), "", phone.text.toString())
        val tokenAutorizacao = getSharedPreferences("dados", 0).getString("token", "")
        RetrofitClient().api.alterarUsuario(id, "Bearer $tokenAutorizacao", dtoUser).enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.code() == 200)
                    Toast.makeText(this@AlteracaoDeUsuarioActivity, "Alteração realizada", Toast.LENGTH_LONG).show();
                else Toast.makeText(this@AlteracaoDeUsuarioActivity, "Falha", Toast.LENGTH_LONG).show();
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Log.e("erro", t.message)
            }
        })
    }
}