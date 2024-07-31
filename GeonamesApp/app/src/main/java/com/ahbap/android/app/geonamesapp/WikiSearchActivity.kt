package com.ahbap.android.app.geonamesapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.geonamesapp.databinding.ActivityWikiSearchBinding
import com.ahbap.android.app.geonamesapp.geonames.IWikiSearchGeonames
import com.ahbap.android.app.geonamesapp.geonames.entity.WikiInfo
import com.ahbap.android.app.geonamesapp.geonames.entity.WikiSearch
import com.ahbap.android.app.geonamesapp.model.WikiSearchModel
import com.ahbap.android.app.geonamesapp.view.WikiActivityListenerView
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class WikiSearchActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityWikiSearchBinding
    @Inject
    lateinit var mGeoWiki : IWikiSearchGeonames
    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_wiki_search)
        mBinding.model = WikiSearchModel()
        mBinding.view = WikiActivityListenerView(this)
        mBinding.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ArrayList<WikiInfo>())


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun GetWikiSearchButtonCallback()
    {
        val call = mGeoWiki.getWikiSearch(mBinding.model!!.str,mBinding.model!!.maxRow)
        mBinding.adapter!!.clear()
        call.enqueue(object : Callback<WikiSearch>{
            override fun onResponse(call: Call<WikiSearch>, response: Response<WikiSearch>) {

                if (response.isSuccessful)
                {
                    val search = response.body()
                    Glide.with(this@WikiSearchActivity)
                        .load(search!!.Wikis[0].thumbnailImg)
                        .into(mBinding.viewsImg)
                   mBinding.adapter!!.addAll(search!!.Wikis)
                    mBinding.adapter!!.notifyDataSetChanged()
                }
                else
                {
                    Toast.makeText(this@WikiSearchActivity, "Null", Toast.LENGTH_SHORT).show()
                }


            }

            override fun onFailure(call: Call<WikiSearch>, t: Throwable) {
                Toast.makeText(this@WikiSearchActivity, "OnFailure", Toast.LENGTH_SHORT).show()
                Log.d("OnFailure",t.message.toString())
            }
        })
    }
}