package com.onionmonster.politicalpreparedness.upcoming

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onionmonster.politicalpreparedness.upcoming.network.ElectionProperty
import com.onionmonster.politicalpreparedness.upcoming.network.ElectionQueryProperty
import com.onionmonster.politicalpreparedness.upcoming.network.ElectionsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


enum class ElectionApiStatus {LOADING, ERROR, DONE}


class UpcomingViewModel: ViewModel() {
    val TAG = "Dev/" + javaClass.simpleName

    private val _status = MutableLiveData<ElectionApiStatus>()
    val status: LiveData<ElectionApiStatus>
        get() = _status

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        Log.d(TAG, "Initialized.")
        getElectionTitles()
    }

    private fun getElectionTitles() {
        viewModelScope.launch {

        }

    }


//        ElectionsApi.retrofitService.getProperties().enqueue(object: Callback<ElectionQueryProperty> {
//            override fun onResponse(call: Call<ElectionQueryProperty>, response: Response<ElectionQueryProperty>) {
////                _response.value = response.body()
//                _response.value = "Success: ${response.body()?.elections?.size} election properties retrieved."
//                Log.d(TAG, "onResponse")
////                Log.d(TAG, "Response code: " + response.code().toString())
//                Log.d(TAG, _response.value.toString())
//            }
//
//            override fun onFailure(call: Call<ElectionQueryProperty>, t: Throwable) {
//                _response.value = "Failure: " + t.message
//                Log.d(TAG, "onFailure")
//                Log.d(TAG, _response.value.toString())
//            }
//        })

}