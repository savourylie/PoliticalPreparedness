package com.onionmonster.politicalpreparedness.upcoming

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import com.onionmonster.politicalpreparedness.data.Election
import com.onionmonster.politicalpreparedness.database.getDatabase
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding
import com.onionmonster.politicalpreparedness.network.ElectionProperty
import com.onionmonster.politicalpreparedness.network.ElectionsApi
import com.onionmonster.politicalpreparedness.repository.ElectionRepository
import kotlinx.coroutines.launch
import java.io.File


enum class ElectionApiStatus {LOADING, ERROR, DONE}


class UpcomingViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "Dev/" + javaClass.simpleName

    private val database = getDatabase(application)
    private val electionRepository = ElectionRepository(database)

    private val _status = MutableLiveData<ElectionApiStatus>()
    val status: LiveData<ElectionApiStatus>
        get() = _status

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response


    private val _properties = MutableLiveData<List<ElectionProperty>>()
    val properties: LiveData<List<ElectionProperty>>
        get() = _properties

    init {
        viewModelScope.launch {
            electionRepository.refreshElections()
        }
    }

    val electionList = electionRepository.elections


//    private fun getElectionTitles() {
//        viewModelScope.launch {
//            try {
//                var listResult = ElectionsApi.retrofitService.getProperties().elections
//
//                if (listResult.isNotEmpty()) {
//                    _properties.value = listResult
//                }
//
//                _response.value = "Success: ${listResult.size} Mars properties retrieved"
//            } catch (e: Exception) {
//                _response.value = "Failure: ${e.message}"
//            }
//        }
//    }



}