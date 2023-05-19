package com.example.homework3_android3.ui.fragments.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework3_android3.App
import com.example.homework3_android3.models.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    fun fetchIdCharacter(id: Int): MutableLiveData<CharacterModel> {

        val data: MutableLiveData<CharacterModel> = MutableLiveData()

        App.characterApi?.fetchIdCharacter(id)?.enqueue(object : Callback<CharacterModel> {
            override fun onResponse(
                call: Call<CharacterModel>,
                response: Response<CharacterModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                data.value = null
                Log.e("error", t.localizedMessage ?: "Error")

            }

        })

        return data
    }
}