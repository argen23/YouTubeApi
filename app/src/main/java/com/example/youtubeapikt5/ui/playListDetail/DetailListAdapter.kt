package com.example.youtubeapikt5.ui.playListDetail
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapikt5.databinding.ItemDetailPlaylistBinding
import com.example.youtubeapikt5.loadImage
import com.example.youtubeapikt5.models.Items
import com.example.youtubeapikt5.models.PlayList
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)

class DetailListAdapter(
    private val playList:PlayList,private val initClick : (id: Items) -> Unit)
    : RecyclerView.Adapter<DetailListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDetailPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playList.items[position])
    }

    override fun getItemCount() : Int {
        return playList.items.size
    }

    inner class ViewHolder( private val binding: ItemDetailPlaylistBinding) : RecyclerView.ViewHolder(binding.root)  {
        fun onBind(playList: Items){
            binding.tvDetailItemTitle.text = playList.snippet.title
            binding.ivItemVideo.loadImage(playList.snippet.thumbnails.default.url)

            val date = playList.snippet.publishedAt
            val zonedDateTime = ZonedDateTime.parse(date)
            val offsetDateTime = OffsetDateTime.parse(date)
            val localOffsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.ofHours(-2))
            val localZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Brazil/DeNoronha"))
           binding.tvDuration.text= String.format(localOffsetDateTime.format(
                DateTimeFormatter.ofPattern("dd-MM-uuuu ")))

            itemView.setOnClickListener{
                initClick(playList)

            }
        }



    }


}