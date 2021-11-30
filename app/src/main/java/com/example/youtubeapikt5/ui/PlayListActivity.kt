package com.example.youtubeapikt5.ui
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapikt5.base.BaseActivity
import com.example.youtubeapikt5.databinding.ActivityMainBinding

class PlayListActivity : BaseActivity<ActivityMainBinding>()  {

    private lateinit var viewModel: PlayListViewModel
    private lateinit var adapter: PlayListAdapter

    override fun setUi() {
        initRecyclerView()
        viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)

    }

    private fun initRecyclerView() {
        viewBinding.rvPa.apply {
            layoutManager = LinearLayoutManager(this@PlayListActivity,LinearLayoutManager.VERTICAL,false)
            adapter = this@PlayListActivity.adapter
        }


    }

    override fun setupLiveData() {

        viewModel.getPlayList().observe(this){
            adapter = PlayListAdapter(it.items,this::initClick)


        }
    }

    private fun initClick(id : String) {
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show()
    }

    override fun checkInternet() {
        
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupClickListener() {

    }


}