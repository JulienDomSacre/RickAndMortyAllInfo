package com.choala.rickandmortyallinfo.episodesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.choala.presentation.episodesList.EpisodesListViewModel
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesListFragment : Fragment(R.layout.fragment_list) {
    private val viewModel: EpisodesListViewModel by viewModel()
    private var searchJob: Job? = null
    private val adapter = EpisodesListAdapter { episodeClicked ->
        val action =
            episodeClicked?.id?.let { episodeId ->
                EpisodesListFragmentDirections.actionEpisodesListToEpisodeDetail(episodeId)
            }
        action?.let { navDirections -> findNavController().navigate(navDirections) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        loadCharacters()
    }

    private fun initAdapter() {
        val linearLayoutManager = LinearLayoutManager(context)
        rv_character.layoutManager = linearLayoutManager
        rv_character.adapter = adapter
    }

    private fun loadCharacters() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.getEpisodeList().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}