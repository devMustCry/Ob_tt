package com.ismael.ob_tt.core

import com.ismael.ob_tt.core.ApiEndPoint.Companion.BASEPATH
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASEPATH)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}