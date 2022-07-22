package com.automatodev.home_ponto.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.config.AppPreferences
import com.automatodev.home_ponto.databinding.ActivitySplashBinding
import com.automatodev.home_ponto.util.UtilTag

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Toast.makeText(this, "Iniciando aplicação.", Toast.LENGTH_SHORT).show()
        resumeSplashScreen()
    }

    private fun resumeSplashScreen() {
        val preferences = AppPreferences(this).getAppPreferences()
        val thread = Thread {
            run {
                Thread.sleep(2000)
                val showIntro = preferences.showIntro ?: false
                if(showIntro) {
                    val intent = Intent(this, IntroAppActivity::class.java)
                    Log.i(UtilTag.TAG, "Activity de introdução")
                    startActivity(intent)

                }else {
                    val intent = Intent(this, MainActivity::class.java)
                    Log.i(UtilTag.TAG, "Activity principal")
                    startActivity(intent)
                }
                finish()
            }
        }
        thread.start()
    }
}