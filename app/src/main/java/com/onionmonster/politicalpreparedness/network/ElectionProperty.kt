package com.onionmonster.politicalpreparedness.network

import com.onionmonster.politicalpreparedness.database.DatabaseElection

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

data class ElectionDetailsQueryProperty(
    val kind: String,
    val election: ElectionProperty,
    val normalizedInput: String,
    val stateList: List<State>
)

data class State(
    val name: String,
    val electionAdministrationBody: ElectionAdministrationBody,
    val sources: List<Source>
)

data class ElectionAdministrationBody(
    val name: String,
    val electionInfoUrl: String,
    val electionRegistrationUrl: String,
    val electionRegistrationConfirmationUrl: String,
    val absenteeVotingInfoUrl: String,
    val votingLocationFinderUrl: String,
    val ballotInfoUrl: String,
    val correspondenceAddress: CorrespondenceAddress
)

data class CorrespondenceAddress(
    val line1: String,
    val city: String,
    val state: String,
    val zip: String
)

data class Source(
    val name: String,
    val official: Boolean
)


fun ElectionQueryProperty.asDatabaseModel(): Array<DatabaseElection> {
    return elections.map {
                DatabaseElection(
                    id = it.id,
                    title = it.name,
                    datetime = it.electionDay,
                    saved = 0
                )
            }.toTypedArray()
}
