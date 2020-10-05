package com.e.myappliedresource.view.activity

import android.accounts.AccountManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.e.myappliedresource.R
import com.e.myappliedresource.databinding.ActivityMainBinding
import com.e.myappliedresource.utils.Global_utility
import com.e.myappliedresource.view.fragment.FourthFragment
import com.e.myappliedresource.view.fragment.HomeFragment
import com.e.myappliedresource.view.fragment.OilGassFragment
import com.e.myappliedresource.view.fragment.ThirdFragment
import com.e.myappliedresource.viewModel.HomeFragVM
import com.google.android.material.tabs.TabLayout
import io.reactivex.disposables.CompositeDisposable
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var viewBinding: ActivityMainBinding? = null
    private var viewModel: ViewModel? = null
    var tabOne: ImageView? = null
    var tabTwo: ImageView? = null
    var tabThree: ImageView? = null
    var tabFour: ImageView? = null
    private var compositeDisposable= CompositeDisposable()
    private lateinit var mAndroidViewModel: HomeFragVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        tabLayout = findViewById(R.id.tabLayout)
        getSetData()

//Token 4b9c72a02fb915ddfc11817e0dfb37dc
//https://api.oilpriceapi.com/v1/prices/latest/?by_code=WTI_USD
    }

    fun getSetData() {
        setupTabIcons()
        viewBinding!!.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.getPosition() == 0) {
                    Global_utility.fragment(this@MainActivity, OilGassFragment(), false)
                    tabOne!!.setImageResource(R.drawable.user_profile_svg)
                    tabThree!!.setImageResource(R.drawable.bag_shop_non_active_svg)
                    tabTwo!!.setImageResource(R.drawable.home_non_active_svg)
                    tabFour!!.setImageResource(R.drawable.message_non_active_svg)

                }  else if (tab.getPosition() == 1) {
                    Global_utility.fragment(this@MainActivity, HomeFragment(), false)
                    tabOne!!.setImageResource(R.drawable.user_profile_non_active_svg)
                    tabThree!!.setImageResource(R.drawable.bag_shop_non_active_svg)
                    tabTwo!!.setImageResource(R.drawable.home_active_svg)
                    tabFour!!.setImageResource(R.drawable.message_non_active_svg)

                }else if (tab.getPosition() == 2) {
                    Global_utility.fragment(this@MainActivity, ThirdFragment(), false)
                    tabOne!!.setImageResource(R.drawable.user_profile_non_active_svg)
                    tabThree!!.setImageResource(R.drawable.bag_shop_active_svg)
                    tabTwo!!.setImageResource(R.drawable.home_non_active_svg)
                    tabFour!!.setImageResource(R.drawable.message_non_active_svg)

                } else if (tab.getPosition() == 3) {
                    //  viewBinding!!.tabLayout.getTabAt(tab.getPosition())!!.setIcon(R.drawable.ic_account_circle_black_24dp)
                    Global_utility.fragment(this@MainActivity, FourthFragment(), false)
                    tabOne!!.setImageResource(R.drawable.user_profile_non_active_svg)
                    tabThree!!.setImageResource(R.drawable.bag_shop_non_active_svg)
                    tabTwo!!.setImageResource(R.drawable.home_non_active_svg)
                    tabFour!!.setImageResource(R.drawable.message_active_svg)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                if (tab.getPosition() == 0) {
                    viewBinding!!.tabLayout.getTabAt(tab.getPosition())!!.setIcon(R.drawable.user_profile_non_active_svg)
                } else if (tab.getPosition() == 1) {
                    viewBinding!!.tabLayout.getTabAt(tab.getPosition())!!.setIcon(R.drawable.home_non_active_svg)
                } else if (tab.getPosition() == 2) {
                    viewBinding!!.tabLayout.getTabAt(tab.getPosition())!!.setIcon(R.drawable.bag_shop_non_active_svg)
                } else if (tab.getPosition() == 3) {
                    viewBinding!!.tabLayout.getTabAt(tab.getPosition())!!.setIcon(R.drawable.message_non_active_svg)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }

        })
        //viewBinding!!.tabLayout.getTabAt(2)!!.select()
    }
    private fun setupTabIcons() {
        //set tabs in tab layout
        var firstTab: TabLayout.Tab = viewBinding!!.tabLayout.newTab()
        firstTab.setIcon(resources.getDrawable(R.drawable.user_profile_non_active_svg))
        viewBinding!!.tabLayout.addTab(firstTab, 0)

        var secondTab: TabLayout.Tab = viewBinding!!.tabLayout.newTab()
        secondTab.setIcon(resources.getDrawable(R.drawable.home_non_active_svg))
        viewBinding!!.tabLayout.addTab(secondTab, 1)

        var thirdTab: TabLayout.Tab = viewBinding!!.tabLayout.newTab()
        thirdTab.setIcon(resources.getDrawable(R.drawable.bag_shop_non_active_svg))
        viewBinding!!.tabLayout.addTab(thirdTab, 2)

        var fourthTab = viewBinding!!.tabLayout.newTab()
        fourthTab.setIcon(resources.getDrawable(R.drawable.message_non_active_svg))
        fourthTab.setText("hjj")
        viewBinding!!.tabLayout.addTab(fourthTab, 3)


        //set custom text and icon for tabs
        tabOne = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ImageView
        tabOne!!.setImageResource(R.drawable.user_profile_non_active_svg)
        viewBinding!!.tabLayout.getTabAt(0)!!.setCustomView(tabOne)

        tabTwo = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ImageView
        tabTwo!!.setImageResource(R.drawable.home_non_active_svg)
        viewBinding!!.tabLayout.getTabAt(1)!!.setCustomView(tabTwo)

        tabThree = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ImageView
        tabThree!!.setImageResource(R.drawable.bag_shop_non_active_svg)
        viewBinding!!.tabLayout.getTabAt(2)!!.setCustomView(tabThree)

        tabFour = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ImageView
        tabFour!!.setImageResource(R.drawable.message_non_active_svg)
        viewBinding!!.tabLayout.getTabAt(3)!!.setCustomView(tabFour)

        println("yahaa_ayaaa..0")
        Global_utility.fragment(this@MainActivity, HomeFragment(), false)
        tabTwo!!.setImageResource(R.drawable.home_active_svg)
        viewBinding!!.tabLayout.getTabAt(1)!!.select()
    }
    override fun onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack()
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {

                // super.onBackPressed()

            } else {
                getSupportFragmentManager().popBackStack()
            }
        }

    }
}