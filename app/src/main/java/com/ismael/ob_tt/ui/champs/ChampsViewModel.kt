package com.ismael.ob_tt.ui.champs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismael.ob_tt.data.model.ChampsResponse
import com.ismael.ob_tt.domain.GetAllChampsUseCase
import com.ismael.ob_tt.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampsViewModel @Inject constructor(
    private val getAllChampsUseCase : GetAllChampsUseCase
) : ViewModel() {

    val champsModel = MutableLiveData<Resource<ChampsResponse>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllChampsUseCase()
            champsModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}
