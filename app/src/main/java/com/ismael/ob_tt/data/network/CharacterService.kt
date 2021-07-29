package com.ismael.ob_tt.data.network

import com.ismael.ob_tt.core.ApiEndPoint.Companion.PRIVATE
import com.ismael.ob_tt.core.ApiEndPoint.Companion.PUBLIC
import com.ismael.ob_tt.core.RetrofitHelper
import com.ismael.ob_tt.data.model.CharacterModel
import com.ismael.ob_tt.util.HashUtils.md5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class CharacterService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllCharacters(): CharacterModel? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CharacterApiClient::class.java).getAllCharacters("1", PUBLIC, md5("1$PRIVATE$PUBLIC"))
            response.body()
        }
    }
}