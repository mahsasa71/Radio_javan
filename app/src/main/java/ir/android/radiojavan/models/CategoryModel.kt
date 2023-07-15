package ir.android.radiojavan.models

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("ONLINE_MP3")
    val category: List<Category>
)
