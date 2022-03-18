package com.automatodev.home_ponto.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {

        var status: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        status = true
    }

    override fun onStop() {
        super.onStop()
        status = false
    }
}