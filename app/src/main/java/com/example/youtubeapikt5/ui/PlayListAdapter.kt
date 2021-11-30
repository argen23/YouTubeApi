package com.example.youtubeapikt5.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapikt5.R
import com.example.youtubeapikt5.databinding.ItemPlaylistBinding
import com.example.youtubeapikt5.loadImage
import com.example.youtubeapikt5.models.Items
import com.example.youtubeapikt5.models.PlayList

class PlayListAdapter(
    private val playList: List<Items>,private val initClick : (id: String) -> Unit) : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.onBind(playList[position])
    }

    override fun getItemCount() : Int {
        return playList.size
    }

    inner class ViewHolder( private val binding:  ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root)  {

        fun onBind(playList: Items ){
            binding.tvTitle.text = playList.snippet.title
            binding.ivPlayList.loadImage(playList.snippet.thumbnails.default.url)

            itemView.setOnClickListener {
                initClick(playList.id)
            }
        }

    }


}