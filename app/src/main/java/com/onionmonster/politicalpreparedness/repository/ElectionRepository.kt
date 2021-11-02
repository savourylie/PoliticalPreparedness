package com.onionmonster.politicalpreparedness.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.onionmonster.politicalpreparedness.data.Election
import com.onionmonster.politicalpreparedness.database.ElectionsDatabase
import com.onionmonster.politicalpreparedness.database.asDomainModel
import com.onionmonster.politicalpreparedness.network.ElectionProperty
import com.onionmonster.politicalpreparedness.network.asDatabaseModel
import com.onionmonster.politicalpreparedness.network.getElectionTitles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching election data from the internet and storing them on disk.
 */
class ElectionRepository(private val database: ElectionsDatabase) {
    val elections: LiveData<List<Election>> = Transformations.map(database.electionDao.getElections()) {
        it.asDomainModel()
    }

    suspend fun refreshElections() {
        withContext(Dispatchers.IO) {
            val electionQueryProperty = getElectionTitles()

            if (electionQueryProperty != null) {
                database.electionDao.insertAll(*electionQueryProperty.asDatabaseModel())
            }
        }
    }
}