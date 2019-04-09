package com.themaker.fshmo.legalhackmos.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

import com.arellomobile.mvp.presenter.InjectPresenter
import com.themaker.fshmo.legalhackmos.R
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment
import com.themaker.fshmo.legalhackmos.presentation.root.NavigateToDtpCallback
import io.reactivex.disposables.CompositeDisposable


class MainFragment : MvpAppCompatFragment(),MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    lateinit var navigateToDtp: NavigateToDtpCallback

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
        navigateToDtp = activity as NavigateToDtpCallback
        dtpImage = rootView.findViewById(R.id.main_dtp_image)
        dtpText = rootView.findViewById(R.id.main_dtp_text)
        inspectorImage = rootView.findViewById(R.id.main_inspector_image)
        inspectorText = rootView.findViewById(R.id.main_inspector_text)
        consImage = rootView.findViewById(R.id.main_cons_image)
        consText = rootView.findViewById(R.id.main_cons_text)
        onPostCreateView()
        return rootView
    }

    private fun onPostCreateView() {
        dtpImage.setOnClickListener { navigateToDtp.navigateToDtp() }
        dtpText.setOnClickListener { navigateToDtp.navigateToDtp() }

    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }


}