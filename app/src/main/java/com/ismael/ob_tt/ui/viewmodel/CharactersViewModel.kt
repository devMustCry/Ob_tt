package com.ismael.ob_tt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.domain.GetAllCharactersUseCase
import com.ismael.ob_tt.domain.GetSelectCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharactersUseCase : GetAllCharactersUseCase,
    private val getSelectCharacterUseCase : GetSelectCharacterUseCase
    ) : ViewModel() {

    val charactersModel = MutableLiveData<AllCharactersResponse>()
    val characterModel = MutableLiveData<CharacterModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllCharactersUseCase()

            if(!result?.status.isNullOrEmpty()){
                charactersModel.postValue(result!!)
                isLoading.postValue(false)
            }else{
                isLoading.postValue(true)
            }
        }
    }

    fun getDetailsCharacter(idCharacter: String){
        viewModelScope.launch {
            val result = getSelectCharacterUseCase(idCharacter)

            if(!result?.resourceURI.isNullOrEmpty()){
                characterModel.postValue(result!!)
                isLoading.postValue(false)
            }else{
                isLoading.postValue(true)
            }
        }
    }
}