package com.example.sabtuseru3_papsi_its.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.ui.movie.MovieFragment
import com.example.sabtuseru3_papsi_its.ui.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_movie -> {
                    loadFragment(MovieFragment())
                }
                R.id.menu_tv -> {
                    loadFragment(TvShowFragment())
                }
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.menu_movie
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrame, fragment, fragment::class.java.simpleName)
            .commit()
    }
}
