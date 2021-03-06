package com.automatodev.home_ponto.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import com.automatodev.home_ponto.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*
import java.util.stream.IntStream

class ChartUtil(val context: Context) {

    fun setDataHorizontalBarChart(
        horizontalBarChart: HorizontalBarChart,
        percent: Float
    ) {

        val xAxis = horizontalBarChart.xAxis
        xAxis.setDrawGridLines(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.isEnabled = true
        xAxis.setDrawAxisLine(false)
        xAxis.labelCount = 4
        xAxis.valueFormatter = formatValuString(arrayOf("", "", "", ""))

        val yLeft = horizontalBarChart.axisLeft
        yLeft.axisMaximum = 100f
        yLeft.axisMinimum = 0f
        yLeft.isEnabled = false

        val yRight = horizontalBarChart.axisRight
        yRight.setDrawAxisLine(true)
        yRight.setDrawGridLines(false)
        yRight.isEnabled = false

        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, percent))

        val dataSet = BarDataSet(entries, "")
        dataSet.barShadowColor = Color.argb(40, 150, 150, 150)
        dataSet.valueFormatter = formatValue("percent")
        dataSet.valueTextColor = Color.WHITE
        dataSet.valueTextSize = 15f
        dataSet.setColors(
            Color.parseColor("#291965")
        )

        val data = BarData(dataSet)
        data.barWidth = 0.8f

        horizontalBarChart.description.text = ""
        horizontalBarChart.legend.isEnabled = false
        horizontalBarChart.setPinchZoom(false)
        horizontalBarChart.isDoubleTapToZoomEnabled = false
        horizontalBarChart.setDrawValueAboveBar(false)
        horizontalBarChart.setTouchEnabled(false)
        horizontalBarChart.isDragEnabled = false
        horizontalBarChart.setScaleEnabled(false)
        horizontalBarChart.isScaleXEnabled = false
        horizontalBarChart.isScaleYEnabled = false
        horizontalBarChart.data = data
        horizontalBarChart.setDrawBarShadow(true)
        horizontalBarChart.invalidate()
        horizontalBarChart.setDrawValueAboveBar(false)
        horizontalBarChart.animateY(2500)
    }

    private fun formatValuString(values: Array<String>): ValueFormatter? {
        val locale = Locale("pt", "br")
        val format = NumberFormat.getCurrencyInstance(locale)
        return object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return values[value.toInt()]
            }
        }
    }

    private fun formatValue(type: String): ValueFormatter? {
        val locale = Locale("pt", "br")
        val format = NumberFormat.getCurrencyInstance(locale)
        return object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return if (type == "cash") format.format(value.toDouble()) else ""
            }
        }
    }
    @SuppressLint("NewApi")
    fun setDataLineChart(balances: List<BigDecimal>, months: List<String?>?,chart:LineChart ) {

        var indexMaxValue = 0

        /*
         * Lista do tipo Entry que recebe um entry passando como prametro os valores do eixo X e eixo y.
         * O parametro no eixo x ?? o que define a linha tenua do grafico (LineChart)
         * */
        val entries: MutableList<Entry> = ArrayList()
        if (balances.size != 0) {
            for (i in balances.indices) {
                entries.add(Entry(i.toFloat(), balances[i].toFloat()))
            }

            /*
             * Configura????es de dados do eixo x - Os coment??rios est??o respectivos as linhas de c??digo
             *
             *  1 - Inicia o eixo X
             *  2 - Dados(labels) do eixo X no Bottom do grafico
             *  3 - Seta a cor dos dados(labels) do eixo X
             *  4 - Tanho do texto(labels) do eixo X
             *  5 - Margem lateral do texto(labels)
             *  6 - Margem de altura do text(labels)
             *  7 - Habilita ou desabilita as informa??oes ou configura????es para este eixo.
             *  8 - desabilita as linhas na vertical do gr??fico
             *  9 - Espessura das linhas dos eixos do gr??fico
             *  10 -
             *  11 -
             *  12 - Seta um ValueFormater personalizado para este eixo
             *
             * */

            /*1*/
            val xAxis = chart.xAxis
            /*2*/xAxis.position = XAxis.XAxisPosition.BOTTOM
            /*3*/xAxis.textColor = Color.parseColor("#256fff")
            /*4*/xAxis.textSize = 10f
            /*5*/xAxis.yOffset = 0f
            /*6*/xAxis.xOffset = 0f
            /*7*/xAxis.isEnabled = false
            /*8*/ xAxis.setDrawGridLines(true);
            /*9*/xAxis.axisLineWidth = 1f
            /*10*/xAxis.granularity = 1f
            /*11*/xAxis.gridColor = Color.WHITE
            /*12*/ //xAxis.setValueFormatter(formatData(mxData));


            /*
             * Configura????es de dados do eixo y direito - Os coment??rios est??o respectivos as linhas de c??digo
             *
             *  1 - Inicia o eixo Y do lado direito do gr??fico
             *  2 - Desabilita a visualiza????o dos dados no eixo Y do lado direito do gr??fico
             *  3 -
             *
             * */

            /*1*/
            val yr = chart.axisRight
            /*2*/yr.isEnabled = false
            /*3*/yr.granularity = 1f

            /*
             * Configura????es de dados do eixo y esquerdo - Os coment??rios est??o respectivos as linhas de c??digo
             *
             *  1 - Inicia o eixo Y do lado esquerdo do grafico
             *  2 - Desabilita a visualiza????o dos dados no eixo Y do lado direito do gr??fico.
             *
             * */

            /*1*/
            val yl = chart.axisLeft
            /*2*/yl.isEnabled = false


            /*
             * Configura????es do dataset - Os coment??rios est??o respectivos as linhas de c??digo
             *
             *  1 - Incicia um novo LineDataSet passando a lista de Entrys e uma label para o grafico
             *  2 - Preenchimento de cor dentro / a baixo da linha tenua do gr??fico
             *  3 - Ativa a linha tenua serrilhada
             *  4 - Valores do eixo Y em cada n?? da linha tenua do gr??fico
             *  5 - Cor do texto do valor em cada n?? da linha tenua do gr??fico
             *  6 - Tamanho do texto do valor em cada n?? da linha tenua do gr??fico
             *  7 - Seta um ValueFormatter para formatar o valor em cada n?? da linha tenua do gr??fico
             *  8 - Espessura da linha em forma de cruz  que linka os dados do eixo y ao eixo x
             *  9 - Cor da linha em fomra de cruz do gr??fico
             *  10 - Cor da bolinha exibida dentro do n?? na linha tenua do gr??fico
             *  11 - Diametro de cada n?? da linha tenua do gr??fico
             *  12 - Diametro da bolinha dentro do n?? na linha tenua do gr??fico
             *  13 - Cor de cada n?? da linha tenua do gr??fico
             *  14 - Parameetriza o tipo de curva que o gr??fico fara em cada n?? encontrado
             *  15 - Para o CUBIC (tipo de curva do gr??fico) parametriza o arredondamento da curva do gr??fico - quanto maior mais redondinho
             *  16 - Cor da linha tenua e da label do gr??fico
             *  17 -  Gradiente (preenchimento) dentro / abaixo da linha tenua do gr??fico
             *  18 - Espessura da linha tenua do gr??fico
             *  19 - ativa ou desativa as bolinhas (n??s de cada valor) deixando o grafico liso
             * */

            /*1*/
            val lineDataSet = LineDataSet(entries, "Saldo das perspectivas")
            /*2*/lineDataSet.setDrawFilled(true)
            /*3*/
            //lineDataSet.enableDashedLine(0, 18, 0); //linha tenua serrilhada
            /*4*/lineDataSet.setDrawValues(false)
            /*5*/lineDataSet.valueTextColor = Color.parseColor("#5A5A5A")
            /*6*/lineDataSet.valueTextSize = 8f
            /*7*/
            //lineDataSet.setValueFormatter(formatValue());
            /*8*/lineDataSet.highlightLineWidth = 0.01f
            /*9*/lineDataSet.highLightColor = Color.parseColor("#ffffff")
            /*10*/lineDataSet.circleHoleColor = Color.parseColor("#ffffff")
            /*11*/lineDataSet.circleRadius = 0f
            /*12*/lineDataSet.circleHoleRadius = 0f
            /*13*/lineDataSet.setCircleColor(Color.parseColor("#00c853"))
            /*14*/lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
            /*15*/lineDataSet.cubicIntensity = 0.2f
            /*16*/lineDataSet.color =
                Color.parseColor("#ffffff") //Cor da linha tenua e da label do grafico
            /*17*/lineDataSet.fillDrawable =
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(
                        Color.parseColor("#BAFFFFFF"),
                        Color.parseColor("#59FFFFFF"),
                        Color.parseColor("#00FA5544")
                    )
                )
            /*18*/lineDataSet.lineWidth = 2f
            /*19*/lineDataSet.setDrawCircles(false)


            /*
             * Configura????es do Data (LineData) - Os coment??rios est??o respectivos as linhas de c??digo
             *
             *  1 - Incicia um novo LineData
             *  2 - seta o dataSet pelo m??todo addDataSet passando o lineDataSet como par??metro
             *
             * */

            /*1*/
            val lineData = LineData()
            /*2*/lineData.addDataSet(lineDataSet)


            /*
             * Configura????es do Chart (Gr??fico) - Os coment??rios est??o respectivos as linhas de c??digo
             *
             *  1 - Seta o lineData no chart(grafico)
             *  2 - Anima????o sentido X da linha tenua do gr??fico passando (tempo em milesegundos)
             *  3 - Desabilita o double toque para zoom do gr??fico
             *  4 - Inicia / atualiza o gr??fico
             *  5 - Seta um texto para NoDataText do gr??fico
             *  6 - Seta uma cor de texto para NoDataText do gr??fico
             *  7 - Desabilita o zoom total do gr??fico
             *  8 - Desabilita a descri????o do gr??fico
             *  9 - Remove as bordas do gr??fico
             *  10 - Habilita / desabilita o toque no gr??fico (pode usar o setOnClickListener() para colocar a????es no toque)
             *  11 - Configura um zoon no gr??fico,  neste caso apenas no eixo X
             *  12 - MarginBottom da label do gr??fico
             *  13 - Desabilita ou habilita a legenda
             * */

            /*1*/chart.data = lineData
            /*2*/chart.animateY(3000, Easing.EaseOutCirc)
            /*3*/chart.isDoubleTapToZoomEnabled = false
            /*4*/chart.invalidate()
            /*5*/chart.setNoDataText("N??o h?? dados a serem exibidos!")
            /*6*/chart.setNoDataTextColor(R.color.gray_596475)
            /*7*/chart.setScaleEnabled(true)
            /*8*/chart.description.isEnabled = false
            /*9*/chart.setDrawBorders(false)
            /*10*/chart.setTouchEnabled(true)
            /*11*/chart.zoom(1f, 1f, 1f, 1f)
            /*12*/chart.extraBottomOffset = 10f
            /*13*/chart.legend.isEnabled = false

            /*
             * Configura????es um MarkerView personalizado
             *
             *  1 - Incicia o markerVIew com seus par??metros de context, layout, lista de texto para legenda do dado.
             *  2 - Configura o gr??fico (chart) no markerView
             *  3 - Configura o markerView como ativo
             *  4 - Configura o markerVIew no gr??fico (chart)
             * */

            /*1*/
            val mk = CustomMarkerView(context , R.layout.layout_marker_view, months)
            /*2*/mk.setChartView(chart)
            /*3*/mk.setActivated(true)
            /*4*/chart.marker = mk


            /*
            *  Traz o index do maior valor da lista de balan??os atravez da variavel indexMaxValue
            * */IntStream.range(0, balances.size).boxed().max(Comparator.comparing { i: Int? ->
                balances[i!!]
            }).ifPresent { index: Int -> indexMaxValue = index }

            /*
        *
        * Mostra o markerView programaticamente na posi????o de maior valor da lista
        *
        * */
            //
            val x = chart.data.dataSets[0].getEntryForIndex(indexMaxValue).x
            val y = chart.data.dataSets[0].getEntryForIndex(indexMaxValue).y
            chart.highlightValue(x, y, 0, true)
        }
        chart.invalidate()
        chart.setNoDataText("N??o h?? dados a serem exibidos!")
        chart.setNoDataTextColor(R.color.qray_5A5A5A)
    }
}