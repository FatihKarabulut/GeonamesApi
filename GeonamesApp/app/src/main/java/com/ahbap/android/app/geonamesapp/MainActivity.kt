package com.ahbap.android.app.geonamesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.geonamesapp.databinding.ActivityMainBinding
import com.ahbap.android.app.geonamesapp.view.MainActivityListenerView

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mBinding.view = MainActivityListenerView(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun WikiButtonCallback()
    {
       startActivity(Intent(this,WikiSearchActivity::class.java))
    }
    fun EarthquakesButtonCallback()
    {
        Intent(this,EarthquakesActivity::class.java).apply { startActivity(this) }
    }
}