package com.example.edvoratask.shapes_drawing

import android.graphics.PointF
import android.view.MotionEvent
import com.example.edvoratask.main_ui.Contract


class ArrowDrawer : ShapeDrawer() {
    var mX = 0f
    var mY = 0f
    lateinit var startPoint: PointF
    lateinit var endPoint: PointF
    override fun draw(event: MotionEvent, myDrawable: Contract.DrawableInterface) {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //myDrawable.canvas.moveTo(x, y)
                myDrawable.moveTo(x, y)
                mX = x
                mY = y
                startPoint = PointF(event.x, event.y)
                endPoint = PointF()
            }

            MotionEvent.ACTION_MOVE -> {
                val dx = Math.abs(x - mX)
                val dy = Math.abs(y - mY)
                mX = x
                mY = y
                endPoint.x = event.x
                endPoint.y = event.y
            }
            MotionEvent.ACTION_UP -> {
                myDrawable.lineTo(mX, mY)
                val deltaX: Float = endPoint.x - startPoint.x
                val deltaY: Float = endPoint.y - startPoint.y
                val frac = 0.1.toFloat()

                val point_x_1: Float = startPoint.x + ((1 - frac) * deltaX + frac * deltaY)
                val point_y_1: Float = startPoint.y + ((1 - frac) * deltaY - frac * deltaX)

                val point_x_2: Float = endPoint.x
                val point_y_2: Float = endPoint.y

                val point_x_3: Float = startPoint.x + ((1 - frac) * deltaX - frac * deltaY)
                val point_y_3: Float = startPoint.y + ((1 - frac) * deltaY + frac * deltaX)

                myDrawable.moveTo(point_x_1, point_y_1)
                myDrawable.lineTo(point_x_2, point_y_2)
                myDrawable.lineTo(point_x_3, point_y_3)
                myDrawable.lineTo(point_x_1, point_y_1)
                myDrawable.lineTo(point_x_1, point_y_1)

                endPoint.x = event.x
                endPoint.y = event.y
            }
        }

    }


}