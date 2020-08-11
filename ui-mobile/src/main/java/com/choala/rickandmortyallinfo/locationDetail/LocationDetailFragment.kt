package com.choala.rickandmortyallinfo.locationDetail

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.choala.domain.model.Location
import com.choala.domain.state.Resource
import com.choala.presentation.locationDetail.LocationDetailViewModel
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.fragment_location_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailFragment : Fragment(R.layout.fragment_location_detail) {
    private val viewModel: LocationDetailViewModel by viewModel()
    private val args: LocationDetailFragmentArgs by navArgs()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getLocation(args.locationId).observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Resource.Success -> showLocationInformation(state.data!!)
                is Resource.Loading -> Toast.makeText(context, "show loading", Toast.LENGTH_SHORT)
                    .show()
                is Resource.Error ->
                    Toast.makeText(context, "error load", Toast.LENGTH_SHORT).show()//TODO
            }
        })
    }

    private fun showLocationInformation(data: Location) {
        tv_locationDetail_name.text = data.name
    }
}