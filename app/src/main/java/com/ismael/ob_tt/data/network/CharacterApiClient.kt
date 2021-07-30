package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.data.model.AllCharactersResponse
import com.ismael.ob_tt.data.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiClient {
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(@Query("ts") ts:String, @Query("apikey") apiKey:String, @Query("hash") hash:String): Response<AllCharactersResponse>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getSelectCharacter(@Path("characterId") id: String, @Query("ts") ts:String, @Query("apikey") apikey : String, @Query("hash") hash: String): Response<CharacterModel>
}