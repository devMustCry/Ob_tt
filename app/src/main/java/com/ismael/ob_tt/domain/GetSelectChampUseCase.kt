package com.ismael.ob_tt.domain

import com.ismael.ob_tt.data.repository.ChampsRepository
import javax.inject.Inject

class GetSelectChampUseCase @Inject constructor(
    private val repository : ChampsRepository
    ) {

    suspend operator fun invoke(id: String) = repository.getChamp(id)

}