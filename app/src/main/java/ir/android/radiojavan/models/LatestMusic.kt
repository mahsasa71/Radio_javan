package ir.android.radiojavan.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LatestMusic(
    @SerializedName("ONLINE_MP3")
    @Expose
    val musics: List<Music>
)
