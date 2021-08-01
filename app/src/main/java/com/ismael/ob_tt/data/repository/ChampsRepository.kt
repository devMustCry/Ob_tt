package com.ismael.ob_tt.data.repository

import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.data.model.ChampsResponse
import com.ismael.ob_tt.data.network.ChampService
import com.ismael.ob_tt.utils.Resource
import javax.inject.Inject

class ChampsRepository @Inject constructor(
    private val api : ChampService,
){
    suspend fun getChamps(): Resource<ChampsResponse> {
        return api.getChamps()
    }

    suspend fun getChamp(idChamp : String): Resource<Champ>{
        return api.getSelectChamp(idChamp)
    }
}