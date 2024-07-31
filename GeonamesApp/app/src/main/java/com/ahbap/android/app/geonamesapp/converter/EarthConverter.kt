package com.ahbap.android.app.geonamesapp.converter

import androidx.databinding.InverseMethod

object EarthConverter {

    @InverseMethod("toStr")
    fun toDouble(str : String) = try {
        str.toDouble()
    }
    catch (ex :NumberFormatException)
    {
        0.0
    }

    fun toStr(str : Double) : String = str.toString()
}