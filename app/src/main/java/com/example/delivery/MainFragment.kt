package com.example.delivery
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.delivery.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigationM)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_wallet -> {
                    replaceFragment(WalletFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_track -> {
                    replaceFragment(TrackFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    replaceFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

        // По умолчанию отображаем HomeFragment
        bottomNavigationView.selectedItemId = R.id.navigation_home
    }
    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_containerM, fragment)
            .commit()
    }
}