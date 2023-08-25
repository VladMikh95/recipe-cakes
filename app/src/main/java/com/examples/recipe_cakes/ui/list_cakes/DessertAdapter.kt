package com.examples.recipe_cakes.ui.list_cakes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.examples.recipe_cakes.data.network.model.Dessert
import com.examples.recipe_cakes.databinding.DessertItemBinding

class DessertAdapter() : ListAdapter<Dessert, DessertAdapter.DessertViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Dessert>() {
            override fun areItemsTheSame(oldItem: Dessert, newItem: Dessert): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Dessert, newItem: Dessert): Boolean {
                return oldItem.idMeal == newItem.idMeal
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertViewHolder {
        val viewHolder = DessertViewHolder(
            DessertItemBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: DessertViewHolder, position: Int) {

        /*holder.itemView.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToDishDialogFragment(getItem(position))
            holder.itemView.findNavController().navigate(action)
        }*/
        holder.bind(getItem(position))
    }

    class DessertViewHolder(private var binding: DessertItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(dessert: Dessert) {

            binding.textViewDessert.text = dessert.strMeal
            binding.imageViewDessert.load(dessert.strMealThumb.toUri().buildUpon().scheme("https").build())
        }
    }
}