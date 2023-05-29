package com.example.disney.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disney.R
import com.example.disney.data.model.ApiResponse

class CharacterAdapter(
    private val characters: ApiResponse.Characters,
    private val onCharacterClick: OnCharacterClick
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val characterLayout: LinearLayout = itemView.findViewById(R.id.characterLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters.data[position]
        holder.nameTextView.text = character?.name
        Glide.with(holder.imageView).load(character?.imageUrl).into(holder.imageView)

        holder.characterLayout.setOnClickListener {
            if (character != null) {
                onCharacterClick.onClick(character)
            }
        }
    }

    override fun getItemCount(): Int {
        return characters.data.size
    }

}