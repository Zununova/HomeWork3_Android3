package com.example.homework3_android3.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.homework3_android3.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserves()
    }

    private fun setupObserves() {
        val args by navArgs<DetailFragmentArgs>()
        viewModel.fetchIdCharacter(args.id).observe(viewLifecycleOwner) {
            binding?.textViewNameHero?.text = it.name
            binding?.textViewGender?.text = it.gender
            binding?.textViewSpecies?.text = it.species
            binding?.textViewType?.text = it.type
            binding?.textViewStatus?.text = it.status
            Glide.with(binding?.imageViewHero!!).load(it.image).into(binding?.imageViewHero!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}