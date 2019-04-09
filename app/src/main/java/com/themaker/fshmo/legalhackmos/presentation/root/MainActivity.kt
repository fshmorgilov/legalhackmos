package com.themaker.fshmo.legalhackmos.presentation.root

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.data.preferences.Preferences
import com.themaker.fshmo.legalhackmos.presentation.fragments.MainFragment
import com.themaker.fshmo.legalhackmos.presentation.fragments.webitem.WebItemFragment

class MainActivity : AppCompatActivity(),MainMenuCallback {

    private val TAG = javaClass.name

    companion object {
        const val NOVELTY_TAG = "Novelties"
    }

    private lateinit var preferences:Preferences
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navigationView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate: ----------------------")
        Log.i(TAG, "onCreate: STARTED")
        drawerLayout = findViewById(R.id.main_base_view_group)
        navigationView = findViewById(R.id.main_navigation)
//        navigationView.
        preferences = Preferences(getPreferences(Context.MODE_PRIVATE))
        preferences.setFirstTimeAppLaunch()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, MainFragment())
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

    override fun showMainNavigation() {
        drawerLayout = findViewById(R.id.main_base_view_group);
        drawerLayout.openDrawer(GravityCompat.START);
        Log.d(TAG, "showMainNavigation: opening navigstion");
    }

    private fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        drawerLayout.closeDrawers()
        when (menuItem.itemId) {
            R.id.main -> supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, MainFragment())
                .addToBackStack("Catalog")
                .commit()
            R.id.nav_novelty -> supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, WebItemFragment())
                .addToBackStack(NOVELTY_TAG)
                .commit()
            R.id.nav_about -> {
            }
        }// TODO: 4/6/2019
        return true
    }
}
