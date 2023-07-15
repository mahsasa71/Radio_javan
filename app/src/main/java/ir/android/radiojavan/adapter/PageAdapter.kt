package ir.android.radiojavan.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentActivity: FragmentActivity,fragments:List<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    var fragmentlist=fragments
    override fun getItemCount(): Int {
        return fragmentlist.size

    }

    override fun createFragment(position: Int): Fragment {
       return fragmentlist.get(position)
    }
}