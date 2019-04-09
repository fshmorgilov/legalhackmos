package com.themaker.fshmo.legalhackmos.presentation.fragments.webitem

import android.content.ClipData.Item
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.themaker.fshmo.legalhackmos.presentation.base.MvpAppCompatFragment
import com.themaker.fshmo.legalhackmos.presentation.base.State
import com.themaker.fshmo.legalhackmos.presentation.root.MainMenuCallback


class WebItemFragment : MvpAppCompatFragment() {

    private var item: Item? = null
    private lateinit var mainMenuCallback: MainMenuCallback

    private lateinit var webView: WebView
    private lateinit var rootView: View
    private lateinit var error: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(com.themaker.fshmo.legalhackmos.R.layout.main_fragment, container, false)
        toolbar = rootView.findViewById(com.themaker.fshmo.legalhackmos.R.id.main_toolbar)
        mainMenuCallback = activity as MainMenuCallback
        onPostCreateView()
        return rootView
    }

    protected fun onPostCreateView() {
        setupWebView()
        val actionBar = (getActivity() as AppCompatActivity).supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
//        actionBar.setHomeAsUpIndicator(R.drawable.)

    }

    private fun setupWebView() {
        webView.settings.loadsImagesAutomatically = true
        webView.settings.useWideViewPort = true
        webView.settings.javaScriptEnabled = true // TODO: 2/8/2019 перепилить
        webView.settings.loadWithOverviewMode = true
        webView.overScrollMode = View.OVER_SCROLL_NEVER
        showState(State.Loading)
        val bundle = this.arguments
    }

    private fun showError(message: String) {
        Log.e(TAG, "onPostCreateView: no data provided for webView. Reason: $message")
        showState(State.NoData)
    }


    fun showState(state: State) {
        Log.i(TAG, "showState: calling state " + state.toString())
        when (state) {
            State.HasData -> {
                webView!!.visibility = View.VISIBLE
                error!!.visibility = View.GONE
                toolbar!!.setVisibility(View.VISIBLE)
            }
            State.NoData -> {
                webView!!.visibility = View.GONE
                error!!.visibility = View.VISIBLE
                toolbar!!.setVisibility(View.VISIBLE)
            }
            State.Loading -> {
                webView!!.visibility = View.GONE
                error!!.visibility = View.GONE
                toolbar!!.setVisibility(View.VISIBLE)
            }
            else -> throw IllegalStateException()
        }// TODO: 2/7/2019 progressbar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                mainMenuCallback.showMainNavigation()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        private val TAG = WebItemFragment::class.java.name
        private val KEY_ID = "BundleKey"

        fun newInstance(item: Item): WebItemFragment {
            val fragment = WebItemFragment()
            val bundle = Bundle()
//            bundle.putSerializable(KEY_ID, item)
            fragment.setArguments(bundle)
            return fragment
        }
    }

}