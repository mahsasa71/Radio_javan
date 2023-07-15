package ir.android.radiojavan.api


import android.util.Log
import ir.android.radiojavan.models.ArtistModel
import ir.android.radiojavan.models.CategoryModel
import ir.android.radiojavan.models.IResponse
import ir.android.radiojavan.models.LatestMusic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCaller {


    var iService: IService = ApiService.retrofit.create(IService::class.java)


    fun getLatestMusic(lister : IResponse<LatestMusic>) {

        iService.getLatestMusics().enqueue(object : Callback<LatestMusic> {
            override fun onResponse(call: Call<LatestMusic>, response: Response<LatestMusic>) {
                Log.e("", "")
                response.body()?.let { lister.onSuccess(it) }
            }

            override fun onFailure(call: Call<LatestMusic>, t: Throwable) {
                Log.e("", "")
                lister.onFailure("error")
            }

        })


    }

    fun searchMusic(search : String,lister : IResponse<LatestMusic>) {

        iService.search(search).enqueue(object : Callback<LatestMusic> {
            override fun onResponse(call: Call<LatestMusic>, response: Response<LatestMusic>) {
                Log.e("", "")
                response.body()?.let { lister.onSuccess(it) }
            }

            override fun onFailure(call: Call<LatestMusic>, t: Throwable) {
                Log.e("", "")
                lister.onFailure("error")
            }

        })


    }

    fun getArtistList(lister : IResponse<ArtistModel>) {

        iService.getartistList().enqueue(object : Callback<ArtistModel> {
            override fun onResponse(call: Call<ArtistModel>, response: Response<ArtistModel>) {
                Log.e("", "")
                response.body()?.let { lister.onSuccess(it) }
            }

            override fun onFailure(call: Call<ArtistModel>, t: Throwable) {
                Log.e("", "")
                lister.onFailure("error")
            }

        })


    }

    fun getCategoriesList(lister : IResponse<CategoryModel>) {

        iService.getCategoryList().enqueue(object : Callback<CategoryModel> {
            override fun onResponse(call: Call<CategoryModel>, response: Response<CategoryModel>) {
                Log.e("", "")
                response.body()?.let { lister.onSuccess(it) }
            }

            override fun onFailure(call: Call<CategoryModel>, t: Throwable) {
                Log.e("", "")
                lister.onFailure("error")
            }

        })


    }



}