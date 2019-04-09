package com.themaker.fshmo.legalhackmos.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import com.arellomobile.mvp.presenter.InjectPresenter
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment
import com.themaker.fshmo.legalhackmos.presentation.root.MainMenuCallback
import com.themaker.fshmo.legalhackmos.presentation.root.NavigateToDtpCallback
import io.reactivex.disposables.CompositeDisposable


class MainFragment : MvpAppCompatFragment(),MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    lateinit var navigateToDtpCallback: NavigateToDtpCallback
    lateinit var navigationCallback: MainMenuCallback

    lateinit var toolbar: Toolbar
    lateinit var rootView: View
    lateinit var dtpImage: ImageView
    lateinit var dtpText: TextView
    lateinit var inspectorImage:ImageView
    lateinit var inspectorText:TextView
    lateinit var consImage:ImageView
    lateinit var consText:TextView

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.main_fragment, container, false)
        toolbar = rootView.findViewById(R.id.main_toolbar)
        navigateToDtpCallback = activity as NavigateToDtpCallback
        navigationCallback = activity as MainMenuCallback
        dtpImage = rootView.findViewById(R.id.main_dtp_image)
        dtpText = rootView.findViewById(R.id.main_dtp_text)
        inspectorImage = rootView.findViewById(R.id.main_inspector_image)
        inspectorText = rootView.findViewById(R.id.main_inspector_text)
        consImage = rootView.findViewById(R.id.main_cons_image)
        consText = rootView.findViewById(R.id.main_cons_text)
        with(toolbar){
            title = "Чем помочь?"

        }
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        setHasOptionsMenu(true)
        onPostCreateView()
        return rootView
    }

    private fun onPostCreateView() {
        dtpImage.setOnClickListener { navigateToDtpCallback.navigateToDtp() }
        dtpText.setOnClickListener { navigateToDtpCallback.navigateToDtp() }

    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navigationCallback.showMainNavigation()
                return true;
            }
            else -> {
                super.onOptionsItemSelected(item); return false
            }
        }
    }


}