package com.example.gdd_ideas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdd_ideas.LoginActivity
import com.example.gdd_ideas.MainActivity
import com.example.gdd_ideas.Tabela.ProjectAdapter
import com.example.gdd_ideas.database.MyDataBase
import com.example.gdd_ideas.database.entities.Proj
import com.example.gdd_ideas.databinding.ActivityProjectsBinding

class ProjectsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProjectsBinding
    private val db by lazy {
        MyDataBase.getDatabase(this@ProjectsActivity).getUserDao()
    }
    val tela : String = "telaLogin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_projects)

        db.checkAllTable()

        /*binding.btnCreateProj.setOnClickListener {
            val intent = Intent(this@ProjectsActivity, LoginActivity::class.java)
            startActivity(intent)
        }*/

        val recyclerView_proj = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView_proj.layoutManager = LinearLayoutManager(this@ProjectsActivity)
        recyclerView_proj.setHasFixedSize(true)

        val listProj: MutableList<Proj> = mutableListOf()
        val adapterProj = ProjectAdapter(this@ProjectsActivity, listProj)
        recyclerView_proj.adapter = adapterProj

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}