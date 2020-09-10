package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_teste_card_v.view.*

class Adapter(private val exampleList: List<PostRepositoryOficial.Repository> ): RecyclerView.Adapter<Adapter.ViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_teste_card_v,
            parent, false)
        return ViewHold(itemView)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        val currentItem = exampleList[position]
        holder.textoNome.text = currentItem.name
        holder.descricao.text = currentItem.descricao
        holder.numeroForks.text = currentItem.numberOfForks.toString()
        holder.numeroWatchers.text = currentItem.numberOfWatchers.toString()
    }

    override fun getItemCount() = exampleList.size

    class ViewHold(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textoNome : TextView = itemView.texto_nome
        val descricao : TextView = itemView.descricao
        val numeroForks : TextView = itemView.numero_forks
        val numeroWatchers : TextView = itemView.numero_watcher
    }
}