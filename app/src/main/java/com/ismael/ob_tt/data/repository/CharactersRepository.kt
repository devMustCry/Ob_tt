package com.ismael.ob_tt.data.repository

import com.ismael.ob_tt.data.local.ChampDao
import com.ismael.ob_tt.data.local.ComicsDao
import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.data.network.CharacterService
import com.ismael.ob_tt.utils.Resource
import com.ismael.ob_tt.utils.performGetOperation
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api : CharacterService,
    private val localDataSource: ChampDao
){
    fun getChamp(id: String) = performGetOperation(
        databaseQuery = { localDataSource.getChamp(id) },
        networkCall = { api.getSelectCharacter(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getChamps() = performGetOperation(
        databaseQuery = { localDataSource.getAllChamps() },
        networkCall = { api.getCharacters() },
        saveCallResult = { localDataSource.insertAll(it.data!!.champs!!) }
    )

}