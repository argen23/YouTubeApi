package com.example.youtubeapikt5.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapikt5.base.BaseActivity
import com.example.youtubeapikt5.databinding.ActivityMainBinding
import com.example.youtubeapikt5.models.Items
import org.koin.androidx.viewmodel.ext.android.viewModel



@SuppressLint("NotifyDataSetChanged")
class PlayListActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: PlayListViewModel by viewModel()
    private var list = arrayListOf<Items>()
    private val adapter by lazy { PlayListAdapter(list, this::initClick) }

    override fun setUi() {

    }

    private fun initRecyclerView() {
        viewBinding.rvPa.apply {
            layoutManager =
                LinearLayoutManager(this@PlayListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = this@PlayListActivity.adapter
        }


    }

    override fun setupLiveData() {

        viewModel.getPlayList().observe(this) {
            list = it.items
            initRecyclerView()

            adapter.notifyDataSetChanged()
        }
    }

    private fun initClick(id: String) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
    }

    override fun checkInternet() {

    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupClickListener() {

    }


}