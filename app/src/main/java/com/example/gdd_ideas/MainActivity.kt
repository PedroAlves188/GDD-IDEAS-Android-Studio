package com.example.gdd_ideas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gdd_ideas.LoginActivity
import com.example.gdd_ideas.database.MyDataBase
import com.example.gdd_ideas.database.entities.Proj
import com.example.gdd_ideas.database.entities.User
import com.example.gdd_ideas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val db by lazy {
        MyDataBase.getDatabase(this@MainActivity).getProjDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        db.checkAllTable()
        db.deleteTable()

        binding.btnEnter.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val projBase1 = Proj(
            "1",
            "Nome",
            "Descrição",
            "Null"
        )
        db.saveProj(projBase1)
        val projBase2 = Proj(
            "2",
            "Nome",
            "Descrição",
            "Null"
        )
        db.saveProj(projBase2)
        val projBase3 = Proj(
            "3",
            "Nome",
            "Descrição",
            "Null"
        )
        db.saveProj(projBase3)

    }
}