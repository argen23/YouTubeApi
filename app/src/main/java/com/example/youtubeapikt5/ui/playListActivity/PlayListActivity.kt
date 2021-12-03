package com.example.youtubeapikt5.ui.playListActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapikt5.base.BaseActivity
import com.example.youtubeapikt5.databinding.ActivityMainBinding
import com.example.youtubeapikt5.models.Items
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.ui.playListDetail.PLayListDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


@SuppressLint("NotifyDataSetChanged")
class PlayListActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: PlayListViewModel by viewModel()
    private lateinit var playList: PlayList
    private val adapter by lazy { PlayListAdapter(playList, this::initClick) }

    override fun setUi() {

    }

    private fun initRecyclerView() {
        viewBinding.rvPa.apply {
            layoutManager =
                LinearLayoutManager(this@PlayListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = this@PlayListActivity.adapter
        }
        adapter.notifyDataSetChanged()

    }

    override fun setupLiveData() {

        viewModel.getPlayList().observe(this) {
            if(it.body()!=null)
            playList = it.body()!!
            initRecyclerView()


        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initClick(id: Items) {
        Intent(this, PLayListDetailActivity::class.java).apply {
            putExtra(PLAYLIST, id.id)
            startActivity(this)

        }
    }


    override fun checkInternet() {

    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupClickListener() {

    }
    companion object{
        const val PLAYLIST = "playlist"
    }
}