package com.example.youtubeapikt5.ui.playListDetail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapikt5.R
import com.example.youtubeapikt5.base.BaseActivity
import com.example.youtubeapikt5.databinding.ActivityPlayListDetailBinding
import com.example.youtubeapikt5.models.Items
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.ui.playListActivity.PlayListActivity.Companion.PLAYLIST
import org.koin.androidx.viewmodel.ext.android.viewModel

@RequiresApi(Build.VERSION_CODES.O)
class PLayListDetailActivity : BaseActivity<ActivityPlayListDetailBinding>() {

    private lateinit var detailList: PlayList

    private val viewModel : PlayListDetailViewModel by viewModel()

    private val detailAdapter : DetailListAdapter by lazy { DetailListAdapter(detailList, this::initClick) }

        private fun initClick(id : Items) {
//        Intent(this, PLayListDetailActivity::class.java)
//        intent.putExtra(PLAYLIST,id)
//        startActivity(intent)
    }

    @SuppressLint("SetTextI18n")
    override fun setupLiveData() {
        viewModel.getDetailPlayList(intent.getStringExtra(PLAYLIST).toString()).observe(this){
            if (it.body() != null)
            detailList = it.body()!!
            initRecyclerView()
        }
        val itemCount = intent.getIntExtra("key_item_count",0)

        viewBinding.tvDetailPlaylistTitle.text = title
        viewBinding.tvDetailSeries.text = "$itemCount  ${getString(R.string.video_series)}"
    }



    private fun initRecyclerView() {
        viewBinding.rvDetail.apply {
            layoutManager =
                LinearLayoutManager(this@PLayListDetailActivity, LinearLayoutManager.VERTICAL, false)
            adapter = this@PLayListDetailActivity.detailAdapter
        }


    }

    override fun setupClickListener() {

    }

    override fun checkInternet() {

//        viewModel.loading.observe(this, {
//            if (it) viewBinding.pbDetailPlaylist.visibility = View.VISIBLE
//            else viewBinding.pbDetailPlaylist.visibility = View.GONE
//        })
//
//        val id = intent.getStringExtra("key_id") ?: "not"
//        viewModel.getDetailPlayList(id).observe(this) { response ->
//
//            when (response.status) {
//
//                Status.LOADING -> viewModel.loading.postValue(true)
//
//                Status.ERROR -> {
//                    viewModel.loading.postValue(false)
//                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
//                }
//
//                Status.SUCCESS -> {
//                    viewModel.loading.postValue(false)
//                    if (response?.data != null) {
//                        response.data.items.let { adapter.addItems(it) }
//                    }
//                }
//            }
//        }
//        getData()
    }

    override fun inflateViewBinding(): ActivityPlayListDetailBinding {
        return ActivityPlayListDetailBinding.inflate(layoutInflater)
    }

    override fun setUi() {

    }


}