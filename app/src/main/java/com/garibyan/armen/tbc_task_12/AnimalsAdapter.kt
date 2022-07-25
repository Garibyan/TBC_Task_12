package com.garibyan.armen.tbc_task_12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.garibyan.armen.tbc_task_12.databinding.RvItemLayoutBinding

class AnimalsAdapter : ListAdapter<Animal, AnimalsAdapter.AnimalViewHolder>(AnimalCallBack()) {

    var onItemClickListener: ((Animal) -> Unit)? = null


    inner class AnimalViewHolder(private val binding: RvItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) = with(binding) {
            imageView.setBackgroundResource(animal.imageSrc)
            root.setOnClickListener {
                onItemClickListener?.invoke(animal)
            }
        }
    }

    class AnimalCallBack : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            RvItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}