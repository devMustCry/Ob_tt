package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.core.ApiEndPoint.Companion.PRIVATE
import com.ismael.ob_tt.core.ApiEndPoint.Companion.PUBLIC
import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.utils.HashUtils.md5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CharacterService @Inject constructor(private val api:CharacterApiClient) : BaseDataSource(){

    /*suspend fun getAllCharacters(): AllCharactersResponse? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCharacters("1", PUBLIC, md5("1$PRIVATE$PUBLIC"))
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }*/

    /*suspend fun getSelectCharacter(idCharacter : String): CharacterModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getSelectCharacter(idCharacter, "1", PUBLIC, md5("1$PRIVATE$PUBLIC"))
            if(response.isSuccessful){
                response.body()
            }else{
                null
            }
        }
    }*/

    suspend fun getCharacters() = getResult { api.getAllCharacters("1", PUBLIC, md5("1$PRIVATE$PUBLIC")) }
    suspend fun getSelectCharacter(id: String) = getResult { api.getSelectCharacter(id, "1", PUBLIC, md5("1$PRIVATE$PUBLIC")) }
}