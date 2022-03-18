package com.automatodev.home_ponto.view.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.viewpager.widget.ViewPager
import com.automatodev.home_ponto.R
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide


class IntroAppActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isButtonBackVisible = false
        isButtonNextVisible = false

        addSlide(
            FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.fragment_wellcome_info, R.style.Theme_Home_ponto_intro).build()
        )

        addSlide(
            FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.fragment_data_info)
                .build()
        )

        addSlide(
            FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.fragment_collect_data)
                .build()
        )

        addSlide(
            FragmentSlide.Builder()
                .fragment(R.layout.fragment_finish_intro)
                .background(R.color.white)
                .canGoForward(false)
                .build()
        )

        addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 3) {
                    isButtonNextVisible = true
                    setButtonNextOnClickListener { startCollectData() }
                } else
                    isButtonNextVisible = false
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    fun startCollectData() {
        if (!CollectDataActivity.status) {
            startActivity(Intent(this, CollectDataActivity::class.java))
            finish()

        }
    }

}