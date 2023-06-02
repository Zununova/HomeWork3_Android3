package com.example.homework3_android3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework3_android3.databinding.OneItemBinding
import com.example.homework3_android3.models.CharacterModel


class CharacterAdapter(private val onItemClick: (name: CharacterModel) -> Unit) :
    ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(getItem(adapterPosition))
            }
        }

        fun onBind(characterModel: CharacterModel?) {
            var id = characterModel?.id?.plus(1)
            Glide.with(binding.imageViewHero).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png")
                .into(binding.imageViewHero)
            binding.textViewNameHero.text = characterModel?.id?.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characterModel = getItem(position)
        characterModel.id = position + 1
        holder.onBind(characterModel)
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<CharacterModel>() {

            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
