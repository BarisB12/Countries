package com.example.countries.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.countries.R
import com.example.countries.databinding.FragmentHomeBinding
import com.example.countries.databinding.FragmentSavedBinding
import com.example.countries.ui.home.CountryAdapter
import com.example.countries.ui.home.HomeViewModel


class SavedFragment : Fragment() {
    private lateinit var binding: FragmentSavedBinding
    private val viewModel: SavedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedBinding.inflate(inflater)

        val adapter = SavedAdapter()

        binding.recyclerViewSaved.adapter = adapter
        viewModel.savedList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}