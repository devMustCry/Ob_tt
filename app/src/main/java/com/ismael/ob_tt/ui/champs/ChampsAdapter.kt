package com.ismael.ob_tt.ui.champs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.databinding.ItemChampBinding
import com.ismael.ob_tt.utils.fromUrl

class ChampsAdapter (private val listener: ClickListener) : RecyclerView.Adapter<ViewHolder>() {

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
        val binding: ItemChampBinding =
            ItemChampBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])
}

class ViewHolder(private val itemBinding: ItemChampBinding, private val listener: ChampsAdapter.ClickListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var champ: Champ

    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: Champ) {
        this.champ = item
        itemBinding.tvName.text = champ.name
        itemBinding.ivChamp.fromUrl("${champ.thumbnail?.path}.${champ.thumbnail?.extension}")
    }

    override fun onClick(v: View?) {
        listener.onItemClick(champ)
    }
}