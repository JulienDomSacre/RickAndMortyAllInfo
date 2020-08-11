package com.choala.rickandmortyallinfo.episodeDetail

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.choala.domain.model.Episode
import com.choala.domain.state.Resource
import com.choala.presentation.episodeDetail.EpisodeDetailViewModel
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.fragment_episode_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {
    private val viewModel: EpisodeDetailViewModel by viewModel()
    private val args: EpisodeDetailFragmentArgs by navArgs()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getEpisode(args.episodeId).observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Resource.Success -> showEpisodeInformation(state.data!!)
                is Resource.Loading -> Toast.makeText(context, "show loading", Toast.LENGTH_SHORT)
                    .show()
                is Resource.Error ->
                    Toast.makeText(context, "error load", Toast.LENGTH_SHORT).show()//TODO
            }
        })
    }

    private fun showEpisodeInformation(data: Episode) {
        tv_episodeDetail_name.text = data.name
    }
}