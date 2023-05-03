package com.example.countries.ui.detail

import android.R
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.countries.databinding.FragmentDetailBinding
import com.example.countries.ui.utils.loadImageFromUrl


class DetailFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private var targetUrl: String = ""
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        viewModel.getDetail(args.country)

        viewModel.detail.observe(viewLifecycleOwner) {
            binding.countryCode.text = it.data.code
            binding.countryName.text = it.data.name
            targetUrl = it.data.wikiDataId
            binding.detailImage.loadImageFromUrl(it.data.flagImageUri)

        }
           binding.buttonLink.setOnClickListener {

            val wiki = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wikidata.org/wiki/"+targetUrl))
            startActivity(wiki)
        }
        return binding.root
    }

}