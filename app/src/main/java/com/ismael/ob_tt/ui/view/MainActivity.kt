package com.ismael.ob_tt.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.databinding.ActivityMainBinding
import com.ismael.ob_tt.ui.adapter.CharactersAdapter
import com.ismael.ob_tt.ui.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val charactersViewModel: CharactersViewModel by viewModels()

    lateinit var listCharacters: List<CharacterModel>
    lateinit var charactersAdapter: CharactersAdapter

    private fun onListItemClick(position: Int) {
        Toast.makeText(this, listCharacters[position].name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        charactersViewModel.onCreate()

        subscribeObservers()

    }

    private fun subscribeObservers(){
        charactersViewModel.charactersModel.observe(this, Observer {
            if(it != null){
                showCharacters(it)
            }else{
                showErrorScreen()
            }

        })

        charactersViewModel.characterModel.observe(this, Observer {
            if(it != null){
                Toast.makeText(this, it.resourceURI, Toast.LENGTH_SHORT).show()
            }else{
                showErrorScreen()
            }
        })

        charactersViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
    }

    private fun showCharacters(response: AllCharactersResponse){

        listCharacters = response.data?.characters!!

        charactersAdapter = CharactersAdapter(listCharacters)
        binding.rvCharacters.setHasFixedSize(true)
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        binding.rvCharacters.adapter = charactersAdapter
        charactersAdapter.notifyDataSetChanged()

        charactersAdapter.setOnItemClickListener(object : CharactersAdapter.ClickListener {
            override fun onItemClick(v: View, position: Int) {
                charactersViewModel.getDetailsCharacter(charactersAdapter.getItem(position).id!!)
            }

        })



    }

    private fun showErrorScreen(){

    }

}