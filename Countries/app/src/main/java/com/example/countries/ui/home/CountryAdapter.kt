package com.example.countries.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.SharedPrefs
import com.example.countries.data.api.model.Country
import com.example.countries.databinding.CountryItemBinding

class CountryAdapter(
    private var countryList: List<Country> = listOf()
) : RecyclerView.Adapter<CountryAdapter.CountryCardHolder>() {
    inner class CountryCardHolder(binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CountryItemBinding

        init {
            this.binding = binding
        }

        fun update(country: Country, context: Context) {
            binding.textviewCountry.text = country.name
            setFavColor(country.isFavorited, binding.favoriteButton, context)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CountryItemBinding = CountryItemBinding.inflate(inflater, parent, false)

        return CountryCardHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryCardHolder, position: Int) {
        val item = holder.binding
        val country = countryList[position]
        val context = item.favoriteButton.context

        item.favoriteButton.setOnClickListener {
            if (country.isFavorited) {
                item.favoriteButton.setColorFilter(ContextCompat.getColor(context, R.color.unFavoriteButtonColor))
                SharedPrefs.removeSavedCountry(country.name)
            } else {
                item.favoriteButton.setColorFilter(ContextCompat.getColor(context, R.color.favoriteButtonColor))
                SharedPrefs.addSavedCountry(country.name)
            }
        }

        holder.update(country, context)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
    
    fun submitList(countryList: List<Country>) {
        this.countryList = countryList
        notifyDataSetChanged()
    }

    private fun setFavColor(isFavorite: Boolean, imageView: ImageView, context: Context) {
        if (isFavorite) {
            imageView.setColorFilter(ContextCompat.getColor(context, R.color.favoriteButtonColor))
        } else {
            imageView.setColorFilter(ContextCompat.getColor(context, R.color.unFavoriteButtonColor))
        }
    }
}