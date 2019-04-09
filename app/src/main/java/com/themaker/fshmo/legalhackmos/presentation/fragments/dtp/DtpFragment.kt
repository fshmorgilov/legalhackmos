package com.themaker.fshmo.legalhackmos.presentation.fragments.dtp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment
import com.themaker.fshmo.legalhackmos.presentation.root.MainMenuCallback

class DtpFragment : MvpAppCompatFragment() {

    private lateinit var rootView: View
    private lateinit var toolber: Toolbar

    lateinit var navigationCallback: MainMenuCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.dtp_fragment, container, false)
        toolber = rootView.findViewById(R.id.dtp_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolber)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        navigationCallback = activity as MainMenuCallback
        toolber.title = "У вас ДТП, что делать?"
        setHasOptionsMenu(true)
        onPostCreateView()
        return rootView
    }

    private fun onPostCreateView() {
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navigationCallback.showMainNavigation()
                return true
            }
            else -> {
                super.onOptionsItemSelected(item); return false
            }
        }
    }
}
