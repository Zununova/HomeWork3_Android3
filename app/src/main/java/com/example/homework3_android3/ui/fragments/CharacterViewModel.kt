package com.example.homework3_android3.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework3_android3.App
import com.example.homework3_android3.models.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    fun fetchCharacters(id: Int): MutableLiveData<List<CharacterModel>?> {
        val data = MutableLiveData<List<CharacterModel>?>()

        App.characterApi?.fetchCharacter(id)
            ?.enqueue(object : Callback<List<CharacterModel>> {
                override fun onResponse(
                    call: Call<List<CharacterModel>>,
                    response: Response<List<CharacterModel>>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<List<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}