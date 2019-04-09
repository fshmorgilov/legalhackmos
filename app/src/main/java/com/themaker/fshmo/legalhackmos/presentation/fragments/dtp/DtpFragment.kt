package com.themaker.fshmo.legalhackmos.presentation.fragments.dtp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment

class DtpFragment : MvpAppCompatFragment() {

    private lateinit var rootView: View
    private lateinit var toolber: Toolbar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.dtp_fragment, container, false)
        toolber = rootView.findViewById(R.id.dtp_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolber)
        toolber.title = "У вас ДТП, что делать?"
        setHasOptionsMenu(true)
        onPostCreateView()
        return rootView
    }

    private fun onPostCreateView() {
    }
}
