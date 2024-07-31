package com.ahbap.android.app.geonamesapp.view

import com.ahbap.android.app.geonamesapp.MainActivity
import com.ahbap.android.app.geonamesapp.WikiSearchActivity
import java.lang.ref.WeakReference

class WikiActivityListenerView(activity : WikiSearchActivity) {
    private val mWeak = WeakReference(activity)

    fun handlerGetWikiSearchButtonCallback() = mWeak.get()!!.GetWikiSearchButtonCallback()
    fun handlerCloseButtonCallback() = mWeak.get()!!.finish()
}