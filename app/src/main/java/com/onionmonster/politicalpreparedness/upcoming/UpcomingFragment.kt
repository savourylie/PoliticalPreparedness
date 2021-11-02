package com.onionmonster.politicalpreparedness.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.onionmonster.politicalpreparedness.R
import com.onionmonster.politicalpreparedness.data.Election
import com.onionmonster.politicalpreparedness.databinding.FragmentUpcomingBinding
import java.io.File


class UpcomingFragment : Fragment(), OnElectionSelectedListener, OnSaveIconSelectedListener {

    val TAG = "Dev/" + javaClass.simpleName

    lateinit var binding: FragmentUpcomingBinding
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

        electionAdapter = ElectionAdapter(this, binding)

        val recyclerView = binding.recyclerUpcomingElection
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = electionAdapter
        }

        viewModel.electionList.observe(viewLifecycleOwner, Observer<List<Election>> { elections ->
            elections?.apply {
                electionAdapter.submitList(elections)
            }
        })

        return binding.root
    }

    override fun onElectionClicked() {
        replaceFragment(UpcomingDetailFragment())
    }

    override fun onSaveIconClicked(election: Election) {

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.recycler_upcoming_election, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}