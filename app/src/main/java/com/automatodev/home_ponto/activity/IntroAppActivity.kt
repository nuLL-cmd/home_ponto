package com.automatodev.home_ponto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.automatodev.home_ponto.R
import com.heinrichreimersoftware.materialintro.app.IntroActivity

class IntroAppActivity : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_app)
    }
}