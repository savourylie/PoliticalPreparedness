package com.onionmonster.politicalpreparedness.upcoming

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.onionmonster.politicalpreparedness.data.Election
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding


class ElectionAdapter(
    private val electionListener: OnElectionSelectedListener,
    private val binding: FragmentUpcomingBinding
): ListAdapter<Election, ElectionViewHolder>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectionViewHolder {
        return ElectionViewHolder.from(parent, electionListener, binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ElectionViewHolder, position: Int) {
        val election = getItem(position)

        holder.bind(election)
    }
}

class EventDiffCallback: DiffUtil.ItemCallback<Election>() {
    override fun areItemsTheSame(oldItem: Election, newItem: Election): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Election, newItem: Election): Boolean {
        return oldItem == newItem
    }
}