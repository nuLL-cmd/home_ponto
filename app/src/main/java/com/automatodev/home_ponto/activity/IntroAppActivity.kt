package com.automatodev.home_ponto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.ActivityIntroAppBinding
import com.heinrichreimersoftware.materialintro.app.IntroActivity

class IntroAppActivity : IntroActivity() {

    private lateinit var binding:ActivityIntroAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro_app)
    }
}