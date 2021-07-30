package com.ismael.ob_tt.data

import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.data.network.CharacterService
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api : CharacterService
){

    suspend fun getAllCharacters(): AllCharactersResponse? {
        return api.getAllCharacters()
    }

    suspend fun getSelectCharacter(idCharacter : String): CharacterModel?{
        return api.getSelectCharacter(idCharacter)
    }
}