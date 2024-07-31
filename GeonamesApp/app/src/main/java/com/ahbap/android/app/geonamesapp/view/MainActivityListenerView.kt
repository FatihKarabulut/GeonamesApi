package com.ahbap.android.app.geonamesapp.view

import com.ahbap.android.app.geonamesapp.MainActivity
import java.lang.ref.WeakReference

class MainActivityListenerView(activity : MainActivity) {
    private val mWeak = WeakReference(activity)

        fun handlerWikiButton() = mWeak.get()!!.WikiButtonCallback()
        fun handlerEarthquakesButton() = mWeak.get()!!.EarthquakesButtonCallback()
}