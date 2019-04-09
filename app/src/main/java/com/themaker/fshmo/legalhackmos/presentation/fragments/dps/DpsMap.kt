package com.themaker.fshmo.legalhackmos.presentation.fragments.dps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment

class DpsMap : MvpAppCompatFragment() {

    private lateinit var rootView: View
    private lateinit var imageView: AppCompatImageView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.dps_fragment, container, false)
        return rootView
    }

}
