package com.automatodev.home_ponto.view.activity

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.automatodev.home_ponto.R
import com.automatodev.home_ponto.databinding.ActivityMainBinding
import com.automatodev.home_ponto.databinding.LayoutDialogExitBinding
import com.automatodev.home_ponto.util.ChartUtil
import com.automatodev.home_ponto.util.CustomMarkerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*
import java.util.stream.IntStream
import kotlin.math.log


class MainActivity : AppCompatActivity(),
    PopupMenu.OnMenuItemClickListener {

    private lateinit var binding: ActivityMainBinding

    companion object {

        var status: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val months = listOf(
            "Janeiro",
            "Fevereiro",
            "Março",
            "Abril",
            "Maio",
            "Junho",
            "Julho",
            "Agosto",
            "Setembro",
            "Outubro",
            "Novembro",
            "Dezembro"
        )
        val values = listOf(
            BigDecimal(12),
            BigDecimal(13),
            BigDecimal(7),
            BigDecimal(10),
            BigDecimal(9),
            BigDecimal(17),
            BigDecimal(18),
            BigDecimal(12),
            BigDecimal(20),
            BigDecimal(7),
            BigDecimal(9),
            BigDecimal(5)
        )


        val chartUtil = ChartUtil(this)
        chartUtil.setDataLineChart(values, months, binding.chart)

        binding.progressbarOne.max = 100
        val currentProgressOne = 63
        binding.progressbarTwo.max = 100
        val currentProgressTwo = 27

        binding.progressbarOne.progressTintList = ColorStateList.valueOf(Color.parseColor("#291965"))

        ObjectAnimator.ofInt(binding.progressbarOne, "progress",currentProgressOne).setDuration(2000).start()

        binding.progressbarTwo.progressDrawable.setColorFilter(
            Color.parseColor("#291965"), android.graphics.PorterDuff.Mode.SRC_IN)

        ObjectAnimator.ofInt(binding.progressbarTwo, "progress",currentProgressTwo).setDuration(2000).start()

    }

    fun showMenu(v: View) {
        val popup = PopupMenu(this, v)
        popup.setOnMenuItemClickListener(this)
        popup.inflate(R.menu.menu_profile)
        popup.show()


    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.itemSettings -> {
                Toast.makeText(this, "Configuraçoes", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.itemAbout -> {
                Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.itemExit -> {
                logout()
                true
            }
            else -> false
        }
    }

    private fun logout() {

        val dialog = BottomSheetDialog(this,R.style.BottomSheetDialogTheme)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val bindingDialog = DataBindingUtil.inflate<LayoutDialogExitBinding>(
            LayoutInflater.from(this),
            R.layout.layout_dialog_exit,
            binding.relativeDaddyAMain,
            false
        )
        bindingDialog.btnExitLDialogExit.setOnClickListener {
            Toast.makeText(this, "Você escolher sair...", Toast.LENGTH_SHORT).show()
            finishAffinity()
        }
        dialog.setContentView(bindingDialog.root)
        dialog.show()

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