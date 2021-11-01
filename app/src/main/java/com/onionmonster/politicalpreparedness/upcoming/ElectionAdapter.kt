package com.onionmonster.politicalpreparedness.upcoming

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding
import com.onionmonster.politicalpreparedness.upcoming.data.dto.PoliticalEvent

class ElectionAdapter(
    private val electionSelectedListener: OnElectionSelectedListener,
    private val binding: FragmentUpcomingBinding
): ListAdapter<PoliticalEvent, ElectionViewHolder>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectionViewHolder {
        return ElectionViewHolder.from(parent, binding, electionSelectedListener)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ElectionViewHolder, position: Int) {
        val election = getItem(position)

        holder.bind(election, position)
    }
}

class EventDiffCallback: DiffUtil.ItemCallback<PoliticalEvent>() {
    override fun areItemsTheSame(oldItem: PoliticalEvent, newItem: PoliticalEvent): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PoliticalEvent, newItem: PoliticalEvent): Boolean {
        return oldItem == newItem
    }
}