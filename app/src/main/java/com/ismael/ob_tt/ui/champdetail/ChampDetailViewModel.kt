package com.ismael.ob_tt.ui.champdetail


import androidx.lifecycle.*
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.domain.GetSelectChampUseCase
import com.ismael.ob_tt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampDetailViewModel @Inject constructor(
    private val getSelectChampUseCase : GetSelectChampUseCase
) : ViewModel() {

    val champModel = MutableLiveData<Resource<Champ>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(idChamp: String){
        viewModelScope.launch {
            val result = getSelectChampUseCase(idChamp)
            isLoading.postValue(true)
            champModel.postValue(result)
            isLoading.postValue(false)
        }
    }

}
