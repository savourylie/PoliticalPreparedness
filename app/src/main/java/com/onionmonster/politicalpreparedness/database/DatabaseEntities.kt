package com.onionmonster.politicalpreparedness.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onionmonster.politicalpreparedness.data.Election

@Entity(tableName = "elections")
data class DatabaseElection constructor(
    @PrimaryKey
    val id: String,
    val title: String,
    val datetime: String,
    val saved: Int
)

fun List<DatabaseElection>.asDomainModel(): List<Election> {
    return map {
        Election(id = it.id, title = it.title, datetime = it.datetime, saved = it.saved)
    }
}