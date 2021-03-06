package com.example.apigithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val exampleList: Domain.Items): RecyclerView.Adapter<Adapter.ViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_view, parent, false)
        return ViewHold(itemView)
    }

    override fun getItemCount() = exampleList.items.size

    override fun onBindViewHolder(holder: ViewHold, position: Int) {
        val currentItem = exampleList.items[position]
        holder.textoNome.text = currentItem.name
        holder.descricao.text = currentItem.descricao
        holder.numeroForks.text = currentItem.numberOfForks.toString()
        holder.numeroWatchers.text = currentItem.numberOfWatchers.toString()
    }

    class ViewHold(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textoNome: TextView = itemView.findViewById(R.id.texto_nome)
        val descricao: TextView = itemView.findViewById(R.id.descricao)
        val numeroForks: TextView = itemView.findViewById(R.id.numero_forks)
        val numeroWatchers: TextView = itemView.findViewById(R.id.numero_watcher)
    }
}