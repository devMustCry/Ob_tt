package com.ismael.ob_tt.domain

import com.ismael.ob_tt.data.CharactersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllCharactersUseCase @Inject constructor(
    private val repository : CharactersRepository
    ) {

    suspend operator fun invoke() = repository.getAllCharacters()

}