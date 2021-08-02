package com.ismael.ob_tt.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ismael.ob_tt.core.ApiEndPoint
import com.ismael.ob_tt.data.network.ChampApiClient
import com.ismael.ob_tt.data.network.ChampService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit() : Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(ApiEndPoint.BASEPATH)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providerChampApiClient(retrofit: Retrofit): ChampApiClient {
        return retrofit.create(ChampApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideChampRemoteDataSource(characterApiClient: ChampApiClient) = ChampService(characterApiClient)

}