package com.ismael.ob_tt.domain

import com.ismael.ob_tt.data.repository.ChampsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllChampsUseCase @Inject constructor(
    private val repository : ChampsRepository
    ) {

    suspend operator fun invoke() = repository.getChamps()

}