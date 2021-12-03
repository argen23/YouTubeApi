package com.example.youtubeapikt5.ui.playListActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapikt5.R
import com.example.youtubeapikt5.databinding.ItemPlaylistBinding
import com.example.youtubeapikt5.loadImage
import com.example.youtubeapikt5.models.Items
import com.example.youtubeapikt5.models.PlayList

class PlayListAdapter(
    private val playList:PlayList, private val initClick:(id : Items) -> Unit)
    : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.onBind(playList.items[position])
    }

    override fun getItemCount() : Int {
        return playList.items.size
    }

    inner class ViewHolder( private val binding:  ItemPlaylistBinding)
        : RecyclerView.ViewHolder(binding.root)  {

        fun onBind(playList: Items ){
            binding.tvTitle.text = playList.snippet.title
            binding.ivPlayList.loadImage(playList.snippet.thumbnails.default.url)

            binding.tvDesc.text = String.format("${playList.contentDetails.itemCount} ${itemView.context.getString(R.string.video_series)}")

            itemView.setOnClickListener {
                initClick(playList)

            }
        }

    }

}