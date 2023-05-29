package com.example.disney.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.disney.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            val character = binding.characterEditText.text.toString().trim()
            if (character.isEmpty()) {
                Toast.makeText(requireContext(), "Write a character name!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToCharacterListFragment(character)
                )
            }
        }

        binding.allCharactersButton.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToCharacterListFragment("all")
            )
        }
    }
}
