package com.example.gdd_ideas

import android.util.Log
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdd_ideas.MainActivity
import com.example.gdd_ideas.database.MyDataBase
import com.example.gdd_ideas.database.daos.UserDao
import com.example.gdd_ideas.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val db by lazy {
        MyDataBase.getDatabase(this@LoginActivity).getUserDao()
    }
    val tela : String = "telaLogin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        db.checkAllTable()

        binding.btnCadaster.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignInActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            if (binding.editNameLogIn.text.isEmpty() and binding.editPasswordLogIn.text.isEmpty()){
                Log.w(tela, "Valor vazio")
            } else {
                val userName=binding.editNameLogIn.text.toString()
                val userPass=binding.editPasswordLogIn.text.toString()
                Log.d(tela, "usuario: $userName")
                Log.d(tela, "senha: $userPass")

                if (db.checkLogin(userName, userPass)) {
                    Log.d(tela, "Usuario localizado")

                    val intent = Intent(this@LoginActivity, ProjectsActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.w(tela, "Usuario não localizado")
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}