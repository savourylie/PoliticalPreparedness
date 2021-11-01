package com.onionmonster.politicalpreparedness.upcoming.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "political_events")
data class PoliticalEvent(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "datetime") var datetime: String,
    @ColumnInfo(name = "saved") var saved: Boolean,
    @PrimaryKey @ColumnInfo(name = "entry_id") val id: String = UUID.randomUUID().toString()
)