package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.core.ApiEndPoint.Companion.HASH
import com.ismael.ob_tt.core.ApiEndPoint.Companion.PUBLIC
import com.ismael.ob_tt.core.RetrofitHelper
import com.ismael.ob_tt.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllCharacters(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CharacterApiClient::class.java).getAllCharacters("1", PUBLIC, HASH)
            response.body() ?: emptyList()
        }
    }
}