package com.automatodev.home_ponto.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.ActivityCollectDataBinding

class CollectDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectDataBinding

    companion object {
        var status: Boolean = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_collect_data)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        binding.btnExitACollectData.setOnClickListener {
            Toast.makeText(applicationContext, "Você escolheu sair...", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnStartACollectData.setOnClickListener {
            if( !MainActivity.status) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }
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