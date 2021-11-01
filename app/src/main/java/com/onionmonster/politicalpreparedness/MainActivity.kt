package com.onionmonster.politicalpreparedness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ToolbarUtils
import com.onionmonster.politicalpreparedness.databinding.ActivityMainBinding
import com.onionmonster.politicalpreparedness.repsearch.RepSearchFragment
import com.onionmonster.politicalpreparedness.repsearch.RepSearchResultFragment
import com.onionmonster.politicalpreparedness.saved.SavedFragment
import com.onionmonster.politicalpreparedness.upcoming.UpcomingFragment

class MainActivity : AppCompatActivity() {
    val TAG = "Dev/" + javaClass.simpleName

    lateinit var binding: ActivityMainBinding

    val fragment1: Fragment = UpcomingFragment()
    val fragment2: Fragment = SavedFragment()
    val fragment3: Fragment = RepSearchFragment()
    val fragment4: Fragment = RepSearchResultFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        fm.beginTransaction().add(R.id.main_container, fragment4, "4").hide(fragment4).commit()
        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.main_container,fragment1, "1").commit()

        val navBar = binding.navigation

        navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_upcoming -> {
                    fm.beginTransaction().hide(active).show(fragment1).commit()
                    active = fragment1
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_saved -> {
                    fm.beginTransaction().hide(active).show(fragment2).commit()
                    active = fragment2
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_rep_search -> {
                    fm.beginTransaction().hide(active).show(fragment3).commit()
                    active = fragment3
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_rep_search_result -> {
                    fm.beginTransaction().hide(active).show(fragment4).commit()
                    active = fragment4
                    return@setOnItemSelectedListener true
                }
            }

            return@setOnItemSelectedListener false
        }

    }



    override fun setSupportActionBar(toolbar: androidx.appcompat.widget.Toolbar?) {
        super.setSupportActionBar(toolbar)

        supportActionBar?.title = "Upcoming Elections"
        supportActionBar?.setDisplayShowTitleEnabled(true)

    }

}