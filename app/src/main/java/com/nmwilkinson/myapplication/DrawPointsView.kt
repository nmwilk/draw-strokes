package com.nmwilkinson.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.FrameLayout

class DrawPointsView(context: Context, attributeSet: AttributeSet) :
    FrameLayout(context, attributeSet) {

    private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.GRAY)

    init {
        setWillNotDraw(false)
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }


    private val paths: List<Path> by lazy {
        points.map { strokePoints ->
            Path().apply {
                val p = strokePoints.map { it + 40f }
                if (strokePoints.isNotEmpty()) {
                    moveTo(p[0], p[1])
                    for (i: Int in 2 until strokePoints.size step 2) {
                        lineTo(p[i], p[i + 1])
                    }
                    close()
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paths.forEachIndexed { index, path ->
            paint.color = colors[index % colors.size]
            canvas.drawPath(path, paint)
        }
    }

    // copy of some simple points to confirm this thing works
//    private val points: List<List<Int>> = listOf(
//        listOf(
//            100,100,
//            500,100,
//        ),
//        listOf(
//            500,100,
//            500,700,
//        ),
//        listOf(
//            500,700,
//            100,700,
//        ),
//        listOf(
//            100,700,
//            100,100
//        ),
//    )

    // add your own here
    private val points: List<List<Int>> = listOf(
        listOf(
            270,18,
            268,19,
            266,38,
            265,51,
            265,59,
            263,68,
            264,86,
            267,111,
            268,124,
            270,136,
            272,147,
            274,172,
            277,209,
            277,228,
            277,236,
            280,240,
            280,259,
            280,270,
            279,290,
            280,315,
            280,316,
            286,316,
            326,316,
            350,316,
            374,316,
            385,316,
            443,316,
            473,316,
            487,316,
            497,318,
            525,317,
            544,317,
            567,318,
            579,318,
            585,317,
            589,298,
            590,287,
            592,282,
            594,262,
            596,250,
            598,227,
            599,214,
            599,208,
            599,182,
            599,143,
            599,121,
            599,110,
            599,66,
            599,31,
            599,15,
            599,6,
            598,1,
            597,1,
            595,1,
            593,1,
            593,1,
            572,0,
            549,2,
            538,4,
            531,3,
            502,8,
            483,12,
            466,15,
            456,16,
            446,17,
            440,19,
            435,20,
            428,19,
            421,21,
            412,21,
            406,21,
            402,24,
            398,23,
            384,25,
            370,25,
            357,25,
            343,25,
            323,23,
            309,23,
            299,23,
            294,24,
            292,23,
            288,21,
            286,21,
            284,21,
            282,21,
            281,21,
            279,19,
            280,20,
            277,20,
        ),
    )
    }