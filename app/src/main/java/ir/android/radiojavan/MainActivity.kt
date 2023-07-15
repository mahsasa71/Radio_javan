package ir.android.radiojavan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import ir.android.radiojavan.activity.SearchActivity
import ir.android.radiojavan.adapter.PageAdapter
import ir.android.radiojavan.databinding.ActivityMainBinding
import ir.android.radiojavan.fragments.CategoriFragment
import ir.android.radiojavan.fragments.FavoriteFragment
import ir.android.radiojavan.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var list= mutableListOf<Fragment>()
        list.add(HomeFragment())
        list.add(CategoriFragment())
        list.add(FavoriteFragment())


        binding.pager.adapter=PageAdapter(this@MainActivity,list)
        binding.bottomMenu.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.item_home->{
                    binding.pager.currentItem=0
                true
                }
                R.id.item_categori->{
                    binding.pager.currentItem=1
                    true
                }
                R.id.item_favorite->{
                    binding.pager.currentItem=2
                    true
                }
            }
            true

        }
        binding.pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0->binding.bottomMenu.menu.findItem(R.id.item_home).setChecked(true)
                   1->binding.bottomMenu.menu.findItem(R.id.item_categori).setChecked(true)
                    2->binding.bottomMenu.menu.findItem(R.id.item_favorite).setChecked(true)
                }

            }

        })
        binding.imgSearch.setOnClickListener({
            var intent=Intent(applicationContext,SearchActivity::class.java)
            startActivity(intent)
        })
    }
}