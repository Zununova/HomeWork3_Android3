package com.example.homework3_android3.data.remote

import com.example.homework3_android3.models.CharacterModel
import com.example.homework3_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("api/v2/pokemon/{id}")
    fun fetchCharacter(
        @Path("id") id: Int
    ): Call<List<CharacterModel>>

    @GET("api/v2/ability/{id}")
    fun fetchIdCharacter(
        @Path("id") id: Int
    ): Call<CharacterModel>

}