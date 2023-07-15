package ir.android.radiojavan.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.android.radiojavan.R
import ir.android.radiojavan.adapter.ArtistAdapter
import ir.android.radiojavan.adapter.MusicsAdapter
import ir.android.radiojavan.api.ApiCaller
import ir.android.radiojavan.models.ArtistModel
import ir.android.radiojavan.models.IResponse
import ir.android.radiojavan.models.LatestMusic


class HomeFragment : Fragment() {
    var apiCaller:ApiCaller= ApiCaller()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View=inflater.inflate(R.layout.fragment_home, container, false)
        var recycler_music=view.findViewById<RecyclerView>(R.id.recycler_music)
        var recycler_artists=view.findViewById<RecyclerView>(R.id.recycler_artists)
        apiCaller.getlatestMusic(object :IResponse<LatestMusic>{
            override fun onSuccess(response: LatestMusic) {
            Log.e("","")
                recycler_music.adapter=MusicsAdapter(requireContext(),response.musics)
                recycler_music.layoutManager=LinearLayoutManager(
                    requireContext(),LinearLayoutManager.HORIZONTAL,false
                )
            }

            override fun onFailure(errorResponse: String) {
                Log.e("","")
            }

        })
        apiCaller.getArtistList()(object :IResponse<ArtistModel>{
            override fun onSuccess(response: LatestMusic) {
                Log.e("","")
                recycler_artists.adapter=ArtistAdapter(requireContext(),response.)
                recycler_artists.layoutManager=LinearLayoutManager(
                    requireContext(),LinearLayoutManager.HORIZONTAL,false
                )
            }

            override fun onFailure(errorResponse: String) {
                Log.e("","")
            }

        })
        return view
    }


}