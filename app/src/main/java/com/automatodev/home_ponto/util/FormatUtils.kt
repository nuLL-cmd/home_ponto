package com.automatodev.home_ponto.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class FormatUtils {

    companion object {

        fun format(date: Long?): String? {
            val locale = Locale("pt", "br")
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", locale)
            return dateFormat.format(date)
        }

        fun numberFormat(value: BigDecimal?): String? {
            val format = NumberFormat.getCurrencyInstance()
            return format.format(value)
        }

        fun numberFormat(value: Float?): String? {
            val format = NumberFormat.getCurrencyInstance()
            return format.format(value)
        }


        fun percentFormatDouble(value: Double?, percent: Boolean): String? {
            val format = DecimalFormat("#.##")
            return if (percent) format.format(value) + "%" else format.format(value)
        }

        fun percentFormatFloat(value: Float?, percent: Boolean): String? {
            val format = DecimalFormat("#.##")
            return if (percent) format.format(value) + "%" else format.format(value)
        }

        fun decimalFormat(value: BigDecimal?): String? {
            val format = DecimalFormat("#,##0.00", DecimalFormatSymbols(Locale("pt", "BR")))
            return format.format(value)
        }
    }


}