package com.ismael.ob_tt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismael.ob_tt.R
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.databinding.ItemCharacterBinding
import com.ismael.ob_tt.util.fromUrl

class CharactersAdapter (private val characters: List<CharacterModel>) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private var clickListener: ClickListener? = null

    interface ClickListener {
        fun onItemClick(v: View,position: Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = characters[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun getItem(position: Int): CharacterModel {
        return characters[position]
    }

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val binding = ItemCharacterBinding.bind(view)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(character: CharacterModel) {
            binding.tvName.text = character.name
            binding.ivCharacter.fromUrl("${character.thumbnail?.path}.${character.thumbnail?.extension}")
        }

        override fun onClick(v: View?) {
            if (v != null) {
                clickListener?.onItemClick(v,adapterPosition)
            }
        }

    }
}