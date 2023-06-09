package com.example.homework3_android3.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("gender")
    val gender: String
)

