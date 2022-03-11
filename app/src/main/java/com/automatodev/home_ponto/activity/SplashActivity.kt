package com.automatodev.home_ponto.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        Toast.makeText(this, "Iniciando aplicação.", Toast.LENGTH_SHORT).show()
        resumeSplashScreen()
    }

    private fun resumeSplashScreen() {
        val thread = Thread(){
            run {
                Thread.sleep(2000)
                val intent = Intent(this, IntroAppActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        thread.start()
    }
}