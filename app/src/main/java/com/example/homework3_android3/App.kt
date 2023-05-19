package com.example.homework3_android3

import android.app.Application
import com.example.homework3_android3.data.RetrofitClient
import com.example.homework3_android3.data.remote.CharacterApi

class App : Application() {

    companion object {
        var characterApi: CharacterApi? = null
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitClient = RetrofitClient()
        characterApi = retrofitClient.provideCharacterApiService()
    }
}