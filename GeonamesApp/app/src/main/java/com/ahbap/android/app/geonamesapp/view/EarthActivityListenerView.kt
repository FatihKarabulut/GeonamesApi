package com.ahbap.android.app.geonamesapp.view

import com.ahbap.android.app.geonamesapp.EarthquakesActivity
import com.ahbap.android.app.geonamesapp.MainActivity
import com.ahbap.android.app.geonamesapp.WikiSearchActivity
import java.lang.ref.WeakReference

class EarthActivityListenerView(activity : EarthquakesActivity) {
    private val mWeak = WeakReference(activity)

    fun handlerGetEarthquakesButtonCallback() = mWeak.get()!!.getButtonEarthquakesCallback()
    fun handlerCloseButtonCallback() = mWeak.get()!!.finish()

}