package com.example.fapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fapp.fragments.FragmentD
import com.example.fapp.fragments.FragmentH
import com.example.fapp.fragments.FragmentS
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dashboardFragment= FragmentD()
    private val homeFragment= FragmentH()
    private val settingsFragment= FragmentS()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(dashboardFragment)

        nav.setOnNavigationItemSelectedListener{
          when (it.itemId){
              R.id.dashboard -> replaceFragment(dashboardFragment)
              R.id.home -> replaceFragment(homeFragment)
              R.id.settings -> replaceFragment(settingsFragment)
          }
            true

       }


    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

}