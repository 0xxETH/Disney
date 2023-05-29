package com.example.disney.presentation.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.disney.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: CharacterFragmentArgs by navArgs()

        val character = args.characterInfo

        binding.nameTextView.text = character.name

        val films = when {
            character.shortFilms?.isNotEmpty() == true -> character.shortFilms.toString()
            character.tvShows?.isNotEmpty() == true -> character.tvShows.toString()
           else -> character.films.toString()
        }

        binding.filmsTextView.text = films

        Glide.with(requireContext()).load(character.imageUrl).into(binding.imageView)

        binding.createdAtTextView.text = character.createdAt

    }

}