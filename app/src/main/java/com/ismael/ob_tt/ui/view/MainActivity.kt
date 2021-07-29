package com.ismael.ob_tt.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.ismael.ob_tt.databinding.ActivityMainBinding
import com.ismael.ob_tt.ui.viewmodel.CharactersViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        charactersViewModel.onCreate()

        charactersViewModel.characterModel.observe(this, Observer {
            binding.tvQuote.text = it.status
        })

    }

}