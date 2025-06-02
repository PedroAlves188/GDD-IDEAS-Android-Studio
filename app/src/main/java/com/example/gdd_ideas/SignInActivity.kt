package com.example.gdd_ideas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdd_ideas.LoginActivity
import com.example.gdd_ideas.database.MyDataBase
import com.example.gdd_ideas.database.entities.User
import com.example.gdd_ideas.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val db by lazy {
        MyDataBase.getDatabase(this@SignInActivity).getUserDao()
    }
    val tela: String = "Cadastro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        db.checkAllTable()

        binding.btnSignIn.setOnClickListener {
            if (binding.editNameSignIn.text.isEmpty() and binding.editEmailSignIn.text.isEmpty()
                and binding.editPasswordSignIn.text.isEmpty() and binding.editConfirmPasswordSignIn.text.isEmpty()){
                print("vazios")
            } else {
                if (binding.editPasswordSignIn.text.toString().equals(binding.editConfirmPasswordSignIn.text.toString())) {
                    val userName=binding.editNameSignIn.text.toString()
                    val userEmail=binding.editEmailSignIn.text.toString()
                    val userPass=binding.editPasswordSignIn.text.toString()

                    val newUser = User(
                        name = userName,
                        email = userEmail,
                        password = userPass
                    )

                    if (db.checkExistEmail(userEmail)) {
                        Log.w(tela, "Email já esiste")
                    } else {
                        db.save(newUser)
                        Log.w(tela, "name: $userName\nemail: $userEmail\n password: $userPass")
                        val intent = Intent(this@SignInActivity, ProjectsActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        binding.btnAccount.setOnClickListener {
            finish()
            /*val intent = Intent(this@SignInActivity, LoginActivity::class.java)
            finishActivity(this@SignInActivity)
            startActivity(intent)*/
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}