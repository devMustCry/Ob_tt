package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.core.ApiEndPoint.Companion.PRIVATE
import com.ismael.ob_tt.core.ApiEndPoint.Companion.PUBLIC
import com.ismael.ob_tt.utils.HashUtils.md5
import javax.inject.Inject


class ChampService @Inject constructor(private val api:ChampApiClient) : BaseDataSource(){

    suspend fun getChamps() = getResult { api.getAllChamps("1", PUBLIC, md5("1$PRIVATE$PUBLIC")) }
    suspend fun getSelectChamp(id: String) = getResult { api.getSelectChamp(id, "1", PUBLIC, md5("1$PRIVATE$PUBLIC")) }

}