package com.ismael.ob_tt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.domain.GetAllCharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    val characterModel = MutableLiveData<CharacterModel>()

    var getAllCharactersUseCase = GetAllCharactersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getAllCharactersUseCase()

            if(!result?.status.isNullOrEmpty()){
                characterModel.postValue(result!!)
            }
        }
    }
}