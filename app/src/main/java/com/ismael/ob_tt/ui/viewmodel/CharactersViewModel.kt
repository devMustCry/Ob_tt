package com.ismael.ob_tt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    val characterModel = MutableLiveData<CharacterModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getCharactersUseCase = GetCharactersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharactersUseCase()

            if(!result.isNullOrEmpty()){
                characterModel.postValue(result[0])
                isLoading.postValue(false)
            }else{
                isLoading.postValue(false)
            }
        }
    }
}