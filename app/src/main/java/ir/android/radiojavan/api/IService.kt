package ir.android.radiojavan.api

import ir.android.radiojavan.models.ArtistModel
import ir.android.radiojavan.models.CategoryModel
import ir.android.radiojavan.models.Latestmusic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IService {
    @GET("api.php?latest")
    fun getlatesrmusics():Call<Latestmusic>
    @GET("api.php")
    fun search(@Query("search_text")text:String):Call<Latestmusic>
    @GET("api.php?artist_list")
    fun artistlist():Call<ArtistModel>
    @GET("api.php?cat_list")
    fun getcategorylist():Call<CategoryModel>
}