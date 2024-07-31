package com.ahbap.android.app.geonamesapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.geonamesapp.databinding.ActivityEarthquakesBinding
import com.ahbap.android.app.geonamesapp.geonames.IEarthGeonames
import com.ahbap.android.app.geonamesapp.geonames.entity.EarthSearch
import com.ahbap.android.app.geonamesapp.geonames.entity.EarthquakeInfo
import com.ahbap.android.app.geonamesapp.model.EarthquakesModel
import com.ahbap.android.app.geonamesapp.view.EarthActivityListenerView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class EarthquakesActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityEarthquakesBinding
    @Inject
    lateinit var IEarth : IEarthGeonames
    private fun initialize()
    {
        mBinding =  DataBindingUtil.setContentView(this,R.layout.activity_earthquakes)
        mBinding.view = EarthActivityListenerView(this)
        mBinding.model = EarthquakesModel()
        mBinding.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,ArrayList<EarthquakeInfo>())


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun getButtonEarthquakesCallback()
    {
        mBinding.adapter!!.clear()
        val north = mBinding.model!!.north
        val south = mBinding.model!!.south
        val east = mBinding.model!!.east
        val west = mBinding.model!!.west
        val call = IEarth.getEarthquakes(north,south,east,west)

        call.enqueue(object : Callback<EarthSearch> {
            override fun onResponse(call: Call<EarthSearch>, response: Response<EarthSearch>) {
                if (response.isSuccessful)
                {
                    mBinding.adapter!!.addAll(response.body()!!.Earth)
                    mBinding.adapter!!.notifyDataSetChanged()
                }
                else
                    Toast.makeText(this@EarthquakesActivity,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<EarthSearch>, t: Throwable) {
                Toast.makeText(this@EarthquakesActivity,"onFailure ${t.message.toString()}",Toast.LENGTH_SHORT).show()
            }
        })

    }

}