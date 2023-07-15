package ir.android.radiojavan.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    var retrofit=Retrofit.Builder()
        .baseUrl("http://flutterapps.ir/apps/radiojavan/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}