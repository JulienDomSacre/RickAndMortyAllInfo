package com.choala.rickandmortyallinfo.locationsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.choala.presentation.locationsList.LocationListViewModel
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsListFragment : Fragment(R.layout.fragment_list) {
    private val viewModel: LocationListViewModel by viewModel()
    private var searchJob: Job? = null
    private val adapter = LocationsListAdapter { locationClicked ->
        val action =
            locationClicked?.id?.let { locationId ->
                LocationsListFragmentDirections.actionLocationsListToLoationDetailFragment(
                    locationId
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
        val linearLayoutManager = LinearLayoutManager(context)
        rv_character.layoutManager = linearLayoutManager
        rv_character.adapter = adapter
    }

    private fun loadCharacters() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.getLocationsList().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}