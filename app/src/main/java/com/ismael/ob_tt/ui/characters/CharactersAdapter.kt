package com.ismael.ob_tt.ui.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.databinding.ItemCharacterBinding
import com.ismael.ob_tt.utils.fromUrl

class CharactersAdapter (private val listener: ClickListener) : RecyclerView.Adapter<ViewHolder>() {

    interface ClickListener {
        fun onItemClick(champ: Champ)
    }

    private val items = ArrayList<Champ>()

    fun setItems(items: List<Champ>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCharacterBinding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])
}

class ViewHolder(private val itemBinding: ItemCharacterBinding, private val listener: CharactersAdapter.ClickListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var champ: Champ

    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: Champ) {
        this.champ = item
        itemBinding.tvName.text = champ.name
        itemBinding.ivCharacter.fromUrl("${champ.thumbnail?.path}.${champ.thumbnail?.extension}")
    }

    override fun onClick(v: View?) {
        listener.onItemClick(champ)
    }
}