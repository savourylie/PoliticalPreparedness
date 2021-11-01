package com.onionmonster.politicalpreparedness.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.onionmonster.politicalpreparedness.R
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding
import com.onionmonster.politicalpreparedness.upcoming.data.dto.PoliticalEvent


class UpcomingFragment : Fragment() {

    val TAG = "Dev/" + javaClass.simpleName

    lateinit var binding: FragmentUpcomingBinding
    private lateinit var eventList: List<PoliticalEvent>
    private lateinit var recyclerView: RecyclerView
    private lateinit var electionAdapter: ElectionAdapter

    private val viewModel: UpcomingViewModel by lazy {
        ViewModelProvider(this).get(UpcomingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_upcoming, container, false)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        return binding.root
    }
}