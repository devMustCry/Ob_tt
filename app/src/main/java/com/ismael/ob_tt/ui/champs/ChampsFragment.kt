package com.ismael.ob_tt.ui.champs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismael.ob_tt.R
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.databinding.ChampsFragmentBinding
import com.ismael.ob_tt.utils.Resource
import com.ismael.ob_tt.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampsFragment : Fragment(), CharactersAdapter.ClickListener {

    private var binding: ChampsFragmentBinding by autoCleared()

    private val champsViewModel: ChampsViewModel by viewModels()

    lateinit var listCharacters: List<Champ>
    lateinit var charactersAdapter: CharactersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChampsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        subscribeObservers()
        champsViewModel.onCreate()
    }

    private fun setupRecyclerView() {
        charactersAdapter = CharactersAdapter(this)
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacters.adapter = charactersAdapter
    }


    private fun subscribeObservers(){

        champsViewModel.charactersModel.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    charactersAdapter.setItems(it.data?.data?.champs!!)
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })

        /*charactersViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })*/
    }

    override fun onItemClick(champ: Champ) {
        findNavController().navigate(
            R.id.action_charactersFragment_to_characterDetailFragment,
            bundleOf("champ" to champ)
        )
    }
}
