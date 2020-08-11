package com.choala.rickandmortyallinfo.charactersList

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.choala.presentation.charactersList.CharacterListViewModel
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : Fragment(R.layout.fragment_list) {
    private val viewModel: CharacterListViewModel by viewModel()
    private var searchJob: Job? = null
    private val adapter = CharactersListAdapter { characterClicked ->
        val action =
            characterClicked?.id?.let { characterId ->
                CharactersListFragmentDirections.actionCharacterListToDetail(
                    characterId
                )
            }
        action?.let { navDirections -> findNavController().navigate(navDirections) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        loadCharacters()
    }

    private fun initAdapter() {
        val gridLayoutManager = GridLayoutManager(context, 2)
        rv_character.layoutManager = gridLayoutManager
        rv_character.adapter = adapter
    }

    private fun loadCharacters() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.getCharacterList().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}