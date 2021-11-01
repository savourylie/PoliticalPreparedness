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
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding
import com.onionmonster.politicalpreparedness.upcoming.data.dto.PoliticalEvent


class ElectionViewHolder private constructor (itemView: View,
                                          val binding: FragmentUpcomingBinding,
                                          private val electionListener: OnElectionSelectedListener,
                                          ): RecyclerView.ViewHolder(itemView) {

    val container: CardView = itemView.findViewById(R.id.election_item)
    private val eventTitle: TextView = itemView.findViewById(R.id.election_title)
    private val eventDateTime: TextView = itemView.findViewById(R.id.election_datetime)

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(event: PoliticalEvent, position: Int) {

        eventTitle.text = event.title
        eventDateTime.text = event.datetime

        container.setOnClickListener {
            electionListener.onElectionClicked(event, this)
        }

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup,
                 binding: FragmentUpcomingBinding,
                 electionListener: OnElectionSelectedListener): ElectionViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.election_item, parent, false) as CardView

            return ElectionViewHolder(view, binding, electionListener)
        }
    }
}