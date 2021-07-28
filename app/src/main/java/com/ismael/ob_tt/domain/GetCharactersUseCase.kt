package com.ismael.ob_tt.domain

import com.ismael.ob_tt.data.CharactersRepository

class GetCharactersUseCase {
    private val repository = CharactersRepository()

    suspend operator fun invoke() = repository.getAllCharacters()
}