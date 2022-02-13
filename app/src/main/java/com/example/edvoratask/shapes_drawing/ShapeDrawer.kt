package com.example.edvoratask.shapes_drawing

import android.view.MotionEvent
import com.example.edvoratask.main_ui.Contract

abstract class ShapeDrawer() {
    var x: Float = 0f
    var y: Float = 0f
    var startX: Float = 0f
    var startY: Float = 0f
    val boundaries: Boundaries = Boundaries()

    // fun to draw the shape
    abstract fun draw(event: MotionEvent,myDrawable: Contract.DrawableInterface)

    //fun to specify the boundaries based on the direction of user finger moving
    fun getShapeBoundaries() {
        boundaries.left = if (x > startX) startX else x
        boundaries.right = if (x > startX) x else startX
        boundaries.top = if (y > startY) startY else y
        boundaries.bottom = if (y > startY) y else startY
    }

}