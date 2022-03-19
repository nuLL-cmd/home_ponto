package com.automatodev.home_ponto.util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import com.automatodev.home_ponto.R
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

@SuppressLint("ViewConstructor")
class CustomMarkerView(context: Context?, layoutResource: Int, mxData: List<String?>?) : MarkerView(
    context,
    layoutResource
) {

    private var txtDataOneMarker: TextView? = findViewById(R.id.txtDataOne_markuer)
    private var txtDataTwoMarker: TextView? = findViewById(R.id.txtDataTwo_marker)
    private var mxData: List<String>? = mxData as List<String>?

    override fun refreshContent(e: Entry, highlight: Highlight?) {
        txtDataOneMarker!!.text = e.y.toString()
        txtDataTwoMarker!!.text = "${mxData!![e.x.toInt()]}"
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF? {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}