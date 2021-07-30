package com.ismael.ob_tt.domain

import com.ismael.ob_tt.data.CharactersRepository
import javax.inject.Inject

class GetSelectCharacterUseCase @Inject constructor(
    private val repository : CharactersRepository
    ) {

    suspend operator fun invoke(idCharacter: String) = repository.getSelectCharacter(idCharacter)

}