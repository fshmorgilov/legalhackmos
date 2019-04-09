package com.themaker.fshmo.legalhackmos.presentation.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment
import com.themaker.fshmo.legalhackmos.presentation.root.MainMenuCallback

class ChatFragment: MvpAppCompatFragment() {

    private lateinit var rootView: View
    private lateinit var imageView: AppCompatImageView
    private lateinit var toolbar: Toolbar


    lateinit var navigationCallback: MainMenuCallback
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.chat_fragment, container, false)
        toolbar = rootView.findViewById(R.id.chat_toolbar)
        toolbar.title = "Карта постов ДПС"
        navigationCallback = activity as MainMenuCallback

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        setHasOptionsMenu(true)
        return rootView
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