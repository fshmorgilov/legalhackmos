package com.themaker.fshmo.legalhackmos.presentation.root

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.themaker.fshmo.legalhackmos.App
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.data.preferences.Preferences

class MainActivity : AppCompatActivity() {
    val TAG = javaClass.name

    companion object {
        const val NOVELTY_TAG = "Novelties"
    }

    private lateinit var preferences:Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate: ----------------------")
        Log.i(TAG, "onCreate: STARTED")
        App.getInstance().getComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        drawerLayout = findViewById(R.id.main_base_view_group)
        val navigationView = findViewById(R.id.main_navigation)
//        navigationView.
        preferences = Preferences(getPreferences(Context.MODE_PRIVATE))
        preferences.setFirstTimeAppLaunch()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, NoveltyFragment())
            .addToBackStack(NOVELTY_TAG)
            .commit()
    }

    override fun onBackPressed() {
        Log.i(TAG, "onBackPressed: ")
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        if (backStackEntryCount > 1) {
            val fragments = supportFragmentManager.fragments
            for (fragment in fragments) {
                if (fragment is WebItemFragment)
                    supportFragmentManager.beginTransaction()
                        .remove(fragment)
                        .commit()
                supportFragmentManager.popBackStack()
                Log.i(TAG, "onBackPressed: details fragment removed")
            }
        } else
            finish()
    }

    private fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        drawerLayout.closeDrawers()
        when (menuItem.itemId) {
            R.id.nav_catalog -> supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, CatalogFragment())
                .addToBackStack("Catalog")
                .commit()
            R.id.nav_about -> {
            }
            R.id.nav_novelty -> supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, NoveltyFragment())
                .addToBackStack(NOVELTY_TAG)
                .commit()
        }// TODO: 4/6/2019
        return true
    }
}
