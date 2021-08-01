package com.ismael.ob_tt.ui.champdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.databinding.ChampDetailFragmentBinding
import com.ismael.ob_tt.utils.Resource
import com.ismael.ob_tt.utils.autoCleared
import com.ismael.ob_tt.utils.fromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampDetailFragment : Fragment() {

    private var binding: ChampDetailFragmentBinding by autoCleared()
    private val viewModel: ChampDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChampDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.get("champ")?.let {(bindCharacter(it as Champ))}
    }

    private fun setupObservers() {
        viewModel.characterModel.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.characterCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.characterCl.visibility = View.GONE
                }
            }
        })
    }

    private fun bindCharacter(champ: Champ) {
        binding.image.fromUrl("${champ.thumbnail?.path}.${champ.thumbnail?.extension}")
        binding.name.text = champ.name
    }
}
