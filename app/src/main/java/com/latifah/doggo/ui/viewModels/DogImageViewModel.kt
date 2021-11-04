package com.latifah.doggo.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latifah.doggo.network.DogsApi
import kotlinx.coroutines.launch
import java.lang.Exception

class DogImageViewModel : ViewModel() {
    private val _message = MutableLiveData<String>()
    val message : LiveData<String> = _message

    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    fun getDogImage() {
        viewModelScope.launch {
            try {
//                response:  {
//                    message:"",
//                    status: "success"
//                }
                val response = DogsApi.retrofitService.getDogPics()
                Log.d("ImageView try", "res.message: ${response.message}")
                _message.value = response.message
                _status.value = response.status

                Log.d("ImageView Model", "getDogImage: $message")
            } catch (e: Exception) {
                _status.value = "Error: ${e.message}"
            }
        }

    }


}