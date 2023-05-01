package com.example.countries.ui.saved

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.SharedPrefs
import com.example.countries.databinding.CountryItemSavedBinding

class SavedAdapter(
    private var countryList: MutableList<String> = mutableListOf()
) : RecyclerView.Adapter<SavedAdapter.SavedCardHolder>() {
    inner class SavedCardHolder(binding: CountryItemSavedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var binding: CountryItemSavedBinding

        init {
            this.binding = binding
        }

        fun update(country: String) {
            binding.textviewCountry.text = country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CountryItemSavedBinding =
            CountryItemSavedBinding.inflate(inflater, parent, false)

        return SavedCardHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedAdapter.SavedCardHolder, position: Int) {
        val item = holder.binding
        val country = countryList[position]
        val context = item.imageViewSaved.context

        item.imageViewSaved.setOnClickListener {
            item.imageViewSaved.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.unFavoriteButtonColor
                )
            )
            SharedPrefs.removeSavedCountry(country)
            countryList.removeAt(position)
            notifyDataSetChanged()
        }

        holder.update(country)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun submitList(countryList: MutableList<String>) {
        this.countryList = countryList
        notifyDataSetChanged()
    }
}
