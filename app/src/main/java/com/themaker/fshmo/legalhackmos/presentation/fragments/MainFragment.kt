package com.themaker.fshmo.legalhackmos.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar

import com.arellomobile.mvp.presenter.InjectPresenter
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment
import io.reactivex.disposables.CompositeDisposable


class MainFragment : MvpAppCompatFragment(),MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    lateinit var toolbar: Toolbar
    lateinit var rootView: View
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.main_fragment, container, false)
        toolbar = rootView.findViewById(R.id.main_toolbar)
        onPostCreateView()
        return rootView
    }

    private fun onPostCreateView() {

    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }


}