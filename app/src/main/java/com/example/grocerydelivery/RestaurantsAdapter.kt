package com.example.grocerydelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerydelivery.data.FoodItem
import kotlinx.android.synthetic.main.a_single_restaurant_row.view.*

class RestaurantsAdapter(private val foodItems: List<FoodItem>) :
    RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.a_single_restaurant_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodItems[position]
        holder.bind(foodItem)
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(foodItem: FoodItem) {
            itemView.foodItemTitle.text = foodItem.name
            itemView.foodPrice.text = "Price: $${foodItem.price}"
            if (foodItem.isHighlyRated) {
                itemView.highlyRatedIcon.visibility = View.VISIBLE
            }

            view.mainPhoto.setOnClickListener {
                view.findNavController().navigate(R.id.action_FirstFragment_to_productInfo)
            }
        }
    }
}