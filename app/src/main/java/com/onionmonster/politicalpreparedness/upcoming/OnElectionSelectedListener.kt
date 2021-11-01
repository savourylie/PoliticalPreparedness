package com.onionmonster.politicalpreparedness.upcoming

import com.onionmonster.politicalpreparedness.upcoming.data.dto.PoliticalEvent

interface OnElectionSelectedListener {
    fun onElectionClicked(election: PoliticalEvent, holder: ElectionViewHolder)
}