package com.onionmonster.politicalpreparedness.upcoming.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onionmonster.politicalpreparedness.upcoming.data.dto.PoliticalEvent


@Database(entities = [PoliticalEvent::class], version = 1, exportSchema = false)
abstract class ElectionsDatabase : RoomDatabase() {

    abstract fun politicalEventDao(): PoliticalEventDao
}