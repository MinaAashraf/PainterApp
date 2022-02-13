package com.example.edvoratask.shapes_drawing

import android.view.MotionEvent
import com.example.edvoratask.main_ui.Contract

class RectangleDrawing : ShapeDrawer() {

    override fun draw(event: MotionEvent, myDrawable: Contract.DrawableInterface) {
        getShapeBoundaries()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                myDrawable.fakeMoveTo(x, y)
                myDrawable.moveTo(x, y)
                startX = x
                startY = y
            }

            MotionEvent.ACTION_MOVE -> {
                myDrawable.resetFakePath()
                myDrawable.addFakeRect(
                    boundaries.left,
                    boundaries.top,
                    boundaries.right,
                    boundaries.bottom,
                )
            }
            MotionEvent.ACTION_UP -> {
                myDrawable.addRect(
                    boundaries.left,
                    boundaries.top,
                    boundaries.right,
                    boundaries.bottom,
                )
            }
        }
    }


}