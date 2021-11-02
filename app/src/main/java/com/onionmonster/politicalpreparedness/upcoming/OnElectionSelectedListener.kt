package com.onionmonster.politicalpreparedness.upcoming

import com.onionmonster.politicalpreparedness.data.Election


interface OnElectionSelectedListener {
    fun onElectionClicked()
}

interface OnSaveIconSelectedListener {
    fun onSaveIconClicked(election: Election)
}