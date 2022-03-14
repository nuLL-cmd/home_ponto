package com.automatodev.home_ponto.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import java.util.jar.Manifest


class IntroAppActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         addSlide(FragmentSlide.Builder()
            .background(R.color.white)
            .fragment(R.layout.fragment_wellcome_info).build())

        addSlide(FragmentSlide.Builder()
            .background(R.color.white)
            .fragment(R.layout.fragment_data_info)
            .build())

        addSlide(FragmentSlide.Builder()
            .background(R.color.white)
            .canGoForward(false)
            .fragment(R.layout.fragment_collect_data).build())

        isButtonBackVisible = false
        isButtonNextVisible = false
    }

    fun startCollectData(view: View) {
        if(!CollectDataActivity.status) {
            startActivity(Intent(this, CollectDataActivity::class.java))
            finish()

        }

    }
}