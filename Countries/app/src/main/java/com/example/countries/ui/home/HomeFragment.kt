package com.example.countries.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.countries.SharedPrefs
import com.example.countries.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        val adapter = CountryAdapter()

        binding.recyclerview.adapter = adapter
        viewModel.countryList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}




