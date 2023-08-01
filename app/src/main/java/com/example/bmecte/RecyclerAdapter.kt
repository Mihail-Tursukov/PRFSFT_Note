package com.example.bmecte

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmecte.databinding.ItemLessonBinding
import com.example.bmecte.model.LessonData
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class RecyclerAdapter(
    private val items: List<LessonData>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root) {
        val tags: ChipGroup
        val title: TextView
        val id: TextView

        init {
            tags = binding.tags
            title = binding.title
            id = binding.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lesson, parent, false)
        return ViewHolder(ItemLessonBinding.bind(view))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = items[position].id
        holder.title.text = items[position].title

        for (tag in items[position].tags) {
            val chip = Chip(holder.itemView.context)
            chip.text = tag
            chip.isCheckable = false
            chip.isClickable = false
            holder.tags.addView(chip)
        }
    }

}