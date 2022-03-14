package com.automatodev.home_ponto.view.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.ActivityIntroAppBinding
import com.automatodev.home_ponto.dto.AppPreferencesDto
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide

class IntroAppActivity : IntroActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        addSlide(FragmentSlide.Builder()
            .background(R.color.white)
            .fragment(R.layout.fragment_registration).build())

        addSlide(FragmentSlide.Builder()
            .background(R.color.white)
            .fragment(R.layout.fragment_data_info)
            .build())

        isButtonBackVisible = false
        isButtonNextVisible = true

    }
}