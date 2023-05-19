package com.example.homework3_android3.data.remote

import com.example.homework3_android3.models.CharacterModel
import com.example.homework3_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("api/character")
    fun fetchCharacter(): Call<RickAndMortyResponse<CharacterModel>>

    @GET("api/character/{id}")
    fun fetchIdCharacter(
        @Path("id") id: Int
    ): Call<CharacterModel>

}