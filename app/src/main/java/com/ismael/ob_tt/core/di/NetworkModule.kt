package com.ismael.ob_tt.core.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ismael.ob_tt.core.ApiEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun providerCharacterApiClient(retrofit: Retrofit): CharacterApiClient{
        return retrofit.create(CharacterApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(characterApiClient: CharacterApiClient) = CharacterService(characterApiClient)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.champDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: CharacterService,
                          localDataSource: ChampDao) =
        CharactersRepository(remoteDataSource, localDataSource)

}