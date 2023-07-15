package ir.android.radiojavan.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import ir.android.radiojavan.adapter.CategoriAdapter
import ir.android.radiojavan.api.ApiCaller
import ir.android.radiojavan.databinding.FragmentCategoriBinding
import ir.android.radiojavan.models.CategoryModel
import ir.android.radiojavan.models.IResponse
import ir.android.radiojavan.models.LatestMusic

class CategoriFragment : Fragment() {
    lateinit var binding: FragmentCategoriBinding
    var apiCaller: ApiCaller = ApiCaller()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentCategoriBinding.inflate(layoutInflater)
        binding.progressbar.visibility=View.VISIBLE
        apiCaller.getartistlist(object :IResponse<CategoryModel>{
            override fun onSuccess(response: LatestMusic) {
                binding.recyclerCategori.adapter= CategoriAdapter(requireContext(), response.category)
                binding.recyclerCategori.layoutManager= GridLayoutManager(
                    requireContext(), 2)
                binding.progressbar.visibility=View.GONE

            }

            override fun onFailure(errorResponse: String) {
                Log.e("","")
                binding.progressbar.visibility=View.GONE

            }

        })
        return view
    }


}