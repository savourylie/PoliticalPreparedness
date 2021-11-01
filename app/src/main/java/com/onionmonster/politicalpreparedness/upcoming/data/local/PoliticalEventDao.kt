package com.onionmonster.politicalpreparedness.upcoming.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.onionmonster.politicalpreparedness.upcoming.data.dto.PoliticalEvent

@Dao
interface PoliticalEventDao {
    @Query("SELECT * FROM political_events")
    suspend fun getElections(): List<PoliticalEvent>

    @Query("SELECT * FROM political_events where entry_id = :electionId")
    suspend fun getElectionById(electionId: String): PoliticalEvent?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveElection(election: PoliticalEvent)

    @Query("DELETE FROM political_events")
    suspend fun deleteAllElections()
}