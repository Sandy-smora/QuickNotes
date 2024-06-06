package com.example.quicknotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.quicknotes.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PageAdapter(supportFragmentManager,lifecycle)
        binding.viewPager2.adapter = adapter
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                if (tab != null) {
                    binding.viewPager2.currentItem = tab.position
                }

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
            }
        })
        binding.viewPager2.registerOnPageChangeCallback(/* callback = */ object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }
}