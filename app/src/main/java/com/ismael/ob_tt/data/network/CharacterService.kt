package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.core.ApiEndPoint.Companion.PRIVATE
import com.ismael.ob_tt.core.ApiEndPoint.Companion.PUBLIC
import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.util.HashUtils.md5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CharacterService @Inject constructor(private val api:CharacterApiClient){

    suspend fun getAllCharacters(): AllCharactersResponse? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCharacters("1", PUBLIC, md5("1$PRIVATE$PUBLIC"))
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }

    suspend fun getSelectCharacter(idCharacter : String): CharacterModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getSelectCharacter(idCharacter, "1", PUBLIC, md5("1$PRIVATE$PUBLIC"))
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }
}