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
                val p = strokePoints.map { it.toFloat() }
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
            100,100,
            500,100,
        ),
        listOf(
            500,100,
            500,700,
        ),
        listOf(
            500,700,
            100,700,
        ),
        listOf(
            100,700,
            100,100
        ),
    )
}