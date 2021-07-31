package com.ismael.ob_tt.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ismael.ob_tt.R
import com.ismael.ob_tt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

    }

    /*private lateinit var binding: ActivityMainBinding

    private val charactersViewModel: CharactersViewModel by viewModels()

    lateinit var listCharacters: List<Champ>
    lateinit var charactersAdapter: CharactersAdapter

    private fun onListItemClick(position: Int) {
        Toast.makeText(this, listCharacters[position].toString(), Toast.LENGTH_SHORT).show()
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

    }*/

}