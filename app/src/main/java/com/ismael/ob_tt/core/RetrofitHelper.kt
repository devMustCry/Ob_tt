package com.ismael.ob_tt.core

import com.ismael.ob_tt.core.ApiEndPoint.Companion.BASEPATH
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASEPATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}