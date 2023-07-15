package ir.android.radiojavan.models
import android.os.Parcelable



data class Music(
    val cat_id: String,
    val category_image: String,
    val category_image_thumb: String,
    val category_name: String,
    val cid: String,
    val id: String,
    val mp3_artist: String,
    val mp3_description: String,
    val mp3_duration: String,
    val mp3_thumbnail_b: String,
    val mp3_thumbnail_s: String,
    val mp3_title: String,
    val mp3_type: String,
    val mp3_url: String,
    val rate_avg: String,
    val total_download: String,
    val total_rate: String,
    val total_views: String
)
