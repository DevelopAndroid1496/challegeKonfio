package com.example.challengekonfio.presentation.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challengekonfio.R
import com.example.challengekonfio.data.model.DogResponse
import com.example.challengekonfio.databinding.ItemDogBinding
import com.example.challengekonfio.domain.model.Dog
import java.util.*

class DogsAdapter (private val listDogResponses: List<Dog>, private var context: Context) : RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = ItemDogBinding.bind(itemView)

        @SuppressLint("CheckResult")
        fun bind(dogResponse: Dog, context: Context){
            binding.tvTitle.text = dogResponse.dogName
            binding.tvDescription.text = dogResponse.description
            binding.textViewYears.text = "Almost  ${dogResponse.age} years"
            Glide.with(context).load(dogResponse.image).centerInside().into(binding.imageViewDog)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dog,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bind(listDogResponses[position], context)}

    override fun getItemCount(): Int = listDogResponses.size
}