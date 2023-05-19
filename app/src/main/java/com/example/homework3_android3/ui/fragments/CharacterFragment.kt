package com.example.homework3_android3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework3_android3.databinding.FragmentCharacyerBinding
import com.example.homework3_android3.models.CharacterModel
import com.example.homework3_android3.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacyerBinding
    private val characterAdapter = CharacterAdapter(this::onItemCLick)

    private fun onItemCLick(characterModel: CharacterModel) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(characterModel.id)
        )
    }

    private var viewModel: CharacterViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacyerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.characterRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setUpObserves() {
        viewModel?.fetchCharacters()?.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it?.results)
        }
    }
}