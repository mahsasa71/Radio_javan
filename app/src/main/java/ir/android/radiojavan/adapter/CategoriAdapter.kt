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
import ir.android.radiojavan.models.Category
import ir.android.radiojavan.models.Music

class CategoriAdapter(mcontext: Context, list: List<Category>): RecyclerView.Adapter<CategoriAdapter.musicsVH>() {
    var context:Context=mcontext
    var categorylists:List<Category> =list
    class musicsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title=itemView.findViewById<AppCompatTextView>(R.id.txt_title)
        var img_music=itemView.findViewById<AppCompatImageView>(R.id.img_music)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): musicsVH {
        var view:View=LayoutInflater.from(context).inflate(R.layout.category_row,null)
        return musicsVH(view)


    }

    override fun onBindViewHolder(holder: musicsVH, position: Int) {
        var category=categorylists.get(position)
        holder.txt_title.setText(category.category_image)
        Glide.with(context)
            .load(category.category_image)
            .into(holder.img_music)


    }

    override fun getItemCount(): Int {

        return categorylists.size
    }
}