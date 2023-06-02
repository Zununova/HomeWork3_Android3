package com.example.homework3_android3.data

import com.example.homework3_android3.data.remote.CharacterApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApi {
        return retrofitClient.create(CharacterApi::class.java)
    }
}