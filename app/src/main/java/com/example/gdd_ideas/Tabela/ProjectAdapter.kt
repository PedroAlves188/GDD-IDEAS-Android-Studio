package com.example.gdd_ideas.Tabela

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.gdd_ideas.R
import com.example.gdd_ideas.database.entities.Proj

class ProjectAdapter(private val context: Context, private val projects: MutableList<Proj>): RecyclerView.Adapter<ProjectAdapter.ProjViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProjViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.project_item, parent, false)
        val holder = ProjViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(
        holder: ProjViewHolder,
        position: Int
    ) {

        holder.name.setText(projects[position].projName)
        holder.desc.setText(projects[position].projDesc)
    }

    override fun getItemCount(): Int = projects.size

    inner class ProjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<EditText>(R.id.projName)
        val desc = itemView.findViewById<EditText>(R.id.projDesc)
    }
}