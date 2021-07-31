package com.ismael.ob_tt.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.domain.GetAllCharactersUseCase
import com.ismael.ob_tt.domain.GetSelectCharacterUseCase
import com.ismael.ob_tt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharactersUseCase : GetAllCharactersUseCase
) : ViewModel() {

    //val characters = repository.getChamps()

    val charactersModel = MutableLiveData<Resource<AllCharactersResponse>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = getAllCharactersUseCase()
            charactersModel.postValue(result)
            //isLoading.postValue(false)
        }
    }

    /*fun getDetailsCharacter(idCharacter: String){
        viewModelScope.launch {
            val result = getSelectCharacterUseCase(idCharacter)

            /*if(!result?.resourceURI.isNullOrEmpty()){
                characterModel.postValue(result!!)
                isLoading.postValue(false)
            }else{
                isLoading.postValue(true)
            }*/
        }
    }*/

}
