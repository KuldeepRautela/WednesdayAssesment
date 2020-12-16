package com.example.wednesdayassesment.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wednesdayassesment.jetpack.model.Artist
import com.example.wednesdayassesment.jetpack.viewmodel.ArtistViewModel
import com.example.wednesdayassesment.ui.adapter.ArtistAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.net.ConnectivityManager
import android.R
import android.util.Log


class MainActivity : AppCompatActivity() {
    lateinit var artistAdapter: ArtistAdapter
    lateinit var dataList: ArrayList<Artist>
    lateinit var viewModel: ArtistViewModel

    companion object {
        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.wednesdayassesment.R.layout.activity_main)
        context = applicationContext
        setUpRecyclerView()
        viewModel = ViewModelProviders.of(this).get(ArtistViewModel::class.java)

    }

    private fun setUpRecyclerView() {
        dataList = arrayListOf()
        artistAdapter = ArtistAdapter(dataList)
        id_recyclerView.adapter = artistAdapter
        id_recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
    }

    fun serachArtist(view: View) {
        if (id_search.query!!.length != 0)
        if(isNetworkConnected()){
            viewModel.getDataFromInternet(id_search.query!!.toString()).observe(this, Observer {
                dataList.clear()
                dataList.addAll(it)
                artistAdapter.notifyDataSetChanged()
                val list = arrayListOf<Artist>()
                dataList.forEach {
                    if(it.trackId!=null && it.trackName!=null)
                        list.add(it)
                }
                viewModel.insertData(list)
            })
        }
        else{
            viewModel.getArtistData(id_search.query!!.toString()).observe(this, Observer {
                dataList.clear()
                dataList.addAll(it)
                artistAdapter.notifyDataSetChanged()
            })
        }

    }
    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}
