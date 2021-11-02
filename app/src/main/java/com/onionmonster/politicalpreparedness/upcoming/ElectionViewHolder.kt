package com.onionmonster.politicalpreparedness.upcoming

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.onionmonster.politicalpreparedness.R
import com.onionmonster.politicalpreparedness.data.Election
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding


class ElectionViewHolder private constructor (itemView: View,
                                              val electionListener: OnElectionSelectedListener,
                                              val binding: FragmentUpcomingBinding,
                                             ): RecyclerView.ViewHolder(itemView) {

    val container: CardView = itemView.findViewById(R.id.election_item)
    private val eventTitle: TextView = itemView.findViewById(R.id.election_title)
    private val eventDateTime: TextView = itemView.findViewById(R.id.election_datetime)

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(event: Election) {
        eventTitle.text = event.title
        eventDateTime.text = event.datetime

        container.setOnClickListener {
            electionListener.onElectionClicked()
        }

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup,
                 electionListener: OnElectionSelectedListener,
                 binding: FragmentUpcomingBinding,
                 ): ElectionViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.election_item, parent, false) as CardView

            return ElectionViewHolder(view, electionListener, binding)
        }
    }
}