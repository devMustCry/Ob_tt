package com.ismael.ob_tt.ui.characterdetail


import androidx.lifecycle.*
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.data.repository.CharactersRepository
import com.ismael.ob_tt.domain.GetSelectCharacterUseCase
import com.ismael.ob_tt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getSelectCharacterUseCase : GetSelectCharacterUseCase
) : ViewModel() {

    val characterModel = MutableLiveData<Resource<Champ>>()
    val isLoading = MutableLiveData<Boolean>()

    /*private val _id = MutableLiveData<String>()

    private val _champ = _id.switchMap { id ->
        repository.getChamp(id)
    }
    val character: LiveData<Resource<Champ>> = _champ


    fun start(id: String) {
        _id.value = id
    }*/

    fun onCreate(idCharacter: String){
        viewModelScope.launch {
            val result = getSelectCharacterUseCase(idCharacter)
            isLoading.postValue(true)
            characterModel.postValue(result)
            isLoading.postValue(false)
        }
    }

}
