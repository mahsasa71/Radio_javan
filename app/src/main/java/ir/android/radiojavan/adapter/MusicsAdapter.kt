package ir.android.radiojavan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.android.radiojavan.R
import ir.android.radiojavan.models.Music

class MusicsAdapter(mcontext: Context,list: List<Music>): RecyclerView.Adapter<MusicsAdapter.musicsVH>() {
    var context:Context=mcontext
    var musiclists:List<Music> =list
    class musicsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title=itemView.findViewById<AppCompatTextView>(R.id.txt_title)
        var img_music=itemView.findViewById<AppCompatImageView>(R.id.img_music)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): musicsVH {
        var view:View=LayoutInflater.from(context).inflate(R.layout.musics_row,null)
        return musicsVH(view)


    }

    override fun onBindViewHolder(holder: musicsVH, position: Int) {
        var music=musiclists.get(position)
        holder.txt_title.setText(music.mp3_title)
        Glide.with(context)
            .load(music.mp3_thumbnail_b)
            .into(holder.img_music)


    }

    override fun getItemCount(): Int {

        return musiclists.size
    }
}