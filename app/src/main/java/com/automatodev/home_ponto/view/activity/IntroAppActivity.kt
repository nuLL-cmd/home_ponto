package com.automatodev.home_ponto.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.FragmentLoginBinding
import com.automatodev.home_ponto.databinding.FragmentRegisterBinding
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide


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
                .build()
        )

        addSlide(
            FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.fragment_login)
                .build()
        )

        addSlide(
            FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.fragment_register)
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
                isPagerIndicatorVisible = position < 4
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


    }

    fun goRegister(view: View) {
        nextSlide()
    }

    fun goLogin(view: View) {
        previousSlide()
    }

    fun testData(view: View) {
        if(!MainActivity.status) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}