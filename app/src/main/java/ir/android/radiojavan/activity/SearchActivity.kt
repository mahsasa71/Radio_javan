package ir.android.radiojavan.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import ir.android.radiojavan.adapter.MusicsAdapter
import ir.android.radiojavan.api.ApiCaller
import ir.android.radiojavan.databinding.ActivitySearchBinding
import ir.android.radiojavan.models.IResponse
import ir.android.radiojavan.models.LatestMusic

class SearchActivity : AppCompatActivity() {
    var apiCaller=ApiCaller()
    lateinit var binding:ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSearch.setOnClickListener({
            var input=binding.edtSearch.text.toString()

            apiCaller.searchMusic(input,object :IResponse<LatestMusic>{
                override fun onSuccess(response: LatestMusic) {
                    binding.recyclerMusic.adapter=MusicsAdapter(
                        applicationContext,response.musics)
                    binding.recyclerMusic.layoutManager=GridLayoutManager(applicationContext,2)

                }

                override fun onFailure(errorResponse: String) {
                }

            })
        })

    }
}