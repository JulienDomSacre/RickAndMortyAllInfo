package com.choala.rickandmortyallinfo.characterDetail

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.choala.domain.model.Character
import com.choala.domain.state.Resource
import com.choala.presentation.characterDetail.CharacterDetailViewModel
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.fragment_character_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {
    private val viewModel: CharacterDetailViewModel by viewModel()
    private val args: CharacterDetailFragmentArgs by navArgs()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getCharacter(args.characterId).observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Resource.Success -> showCharacterInformation(state.data!!)
                is Resource.Loading -> Toast.makeText(context, "show loading", Toast.LENGTH_SHORT)
                    .show()
                is Resource.Error ->
                    Toast.makeText(context, "error load", Toast.LENGTH_SHORT).show()//TODO
            }
        })
    }

    private fun showCharacterInformation(data: Character) {
        tv_characterDetail_name.text = data.name
        iv_characterDetail__head.load(data.image)
    }
}