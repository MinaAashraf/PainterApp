package com.example.edvoratask.shapes_drawing

import android.view.MotionEvent
import com.example.edvoratask.main_ui.Contract

class HandDrawing() : ShapeDrawer() {

    override fun draw(event: MotionEvent, myDrawable: Contract.DrawableInterface) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                myDrawable.moveTo(x, y)
                startX = x
                startY = y
            }
            MotionEvent.ACTION_MOVE -> {
                myDrawable.lineTo(x, y)
            }
        }
    }
}

