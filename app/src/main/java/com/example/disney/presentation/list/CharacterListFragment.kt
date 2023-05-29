package com.example.disney.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disney.data.model.Data
import com.example.disney.databinding.FragmentCharacterListBinding
import com.example.disney.presentation.model.CharactersResult

class CharacterListFragment : Fragment(), OnCharacterClick {
    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        if (savedInstanceState == null) {
            val args: CharacterListFragmentArgs by navArgs()
            if (args.characterName == "any") {
                viewModel.loadAllCharacters()
            } else {
                viewModel.loadCharactersByName(args.characterName)
            }
        }

        viewModel.charactersLiveData().observe(viewLifecycleOwner) {
            if (it is CharactersResult.Success) {
                binding.errorTextView.visibility = View.GONE
                binding.charactersRecyclerView.adapter = CharacterAdapter(it.characters, this)
            } else if (it is CharactersResult.Error) {
                binding.errorTextView.visibility = View.VISIBLE
                binding.errorTextView.text = it.errorMessage
            }
        }

    }

    private fun initRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.charactersRecyclerView.layoutManager = layoutManager
    }

    override fun onClick(characterInfo: Data) {
        findNavController().navigate(CharacterListFragmentDirections.actionCharacterListFragmentToCharacterFragment(characterInfo))
    }
}

interface OnCharacterClick {
    fun onClick(characterInfo: Data)
}