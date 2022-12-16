package com.kamuran.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class MainActivity : AppCompatActivity() {
    lateinit var vPager:ViewPager
    lateinit var tLayout:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vPager= viewPager //kaydırma için

        tLayout=tabLayout

        viewPagerOlustur()

        tLayout.setupWithViewPager(vPager)

        tLayout.addTab(tLayout.newTab())
        tLayout.addTab(tLayout.newTab())
        tabOlustur()
    }
fun tabOlustur(){

    val tab1=LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
    tab1.textView.text = "tab 1"
    tab1.imageView.setImageResource(R.mipmap.belge)
    tLayout.getTabAt(0)?.setCustomView(tab1)


    val tab2= LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
    tab2.textView.text= "tab 2"
    tab2.imageView.setImageResource(R.mipmap.profil)
    tLayout.getTabAt(1)?.setCustomView(tab2)
}
    fun viewPagerOlustur(){

val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.FragmetEkle(BlankFragment1())
        adapter.FragmetEkle(BlankFragment2())
        vPager.adapter=adapter

    }


    internal class ViewPagerAdapter(manager:FragmentManager):FragmentPagerAdapter(manager){
        private val fragmentLİst: MutableList<Fragment> =ArrayList()
        override fun getCount(): Int {
            return fragmentLİst.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentLİst[position]
        }
fun FragmetEkle(fragment: Fragment){
    fragmentLİst.add(fragment)
}
    }
}