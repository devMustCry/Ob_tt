package com.ismael.ob_tt.data

import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.data.network.CharacterService

class CharactersRepository {
    private val api = CharacterService()

    suspend fun getAllCharacters(): List<CharacterModel> {
        return api.getAllCharacters()
    }
}