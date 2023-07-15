package ir.android.radiojavan.models

import com.google.gson.annotations.SerializedName

data class ArtistModel(
    @SerializedName("ONLINE_MP3")
    val artistList: List<Artist>
)
