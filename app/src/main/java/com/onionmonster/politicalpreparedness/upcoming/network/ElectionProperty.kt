package com.onionmonster.politicalpreparedness.upcoming.network

data class ElectionQueryProperty(
    val kind: String,
    val elections: List<ElectionProperty>
)

data class ElectionProperty(
    val id: String,
    val name: String,
    val electionDay: String,
    val ocdDivisionId: String
)