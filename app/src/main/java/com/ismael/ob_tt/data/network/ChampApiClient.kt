package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.data.model.Champ
import com.ismael.ob_tt.data.model.ChampsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChampApiClient {
    @GET("/v1/public/characters")
    suspend fun getAllChamps(@Query("ts") ts:String, @Query("apikey") apiKey:String, @Query("hash") hash:String): Response<ChampsResponse>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getSelectChamp(@Path("characterId") id: String, @Query("ts") ts:String, @Query("apikey") apikey : String, @Query("hash") hash: String): Response<Champ>
}