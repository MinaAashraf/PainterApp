package com.example.edvoratask.custom_drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import com.example.edvoratask.main_ui.Contract


class MyDrawable() : Drawable(), Contract.DrawableInterface {
    private var myPath: Path = Path()
    private val myFakePath: Path = Path()
    private val myPaint: Paint = PaintFactory.create()

    val path_color_List = mutableListOf<Pair<Path,Int>>()


    override fun setPaintColor(color: Int) {
        myPaint.color = color
        path_color_List.add(Pair(myPath, myPaint.color))

    }

    override fun moveTo(x: Float, y: Float) {
        myPath.moveTo(x, y)
        path_color_List.add(Pair(myPath, myPaint.color))
    }

    override fun lineTo(x: Float, y: Float) {
        myPath.lineTo(x, y)
    }

    override fun addOval(left: Float, top: Float, right: Float, bottom: Float) {
        myPath.addOval(left, top, right, bottom, Path.Direction.CW)
        path_color_List.add(Pair(myPath, myPaint.color))
        myPath = Path()
    }


    override fun addRect(left: Float, top: Float, right: Float, bottom: Float) {
        myPath.addRect(left, top, right, bottom, Path.Direction.CW)
        path_color_List.add(Pair(myPath, myPaint.color))
        myPath = Path()
    }

    override fun resetPath() {
        myPath.reset()
    }

    //===================================================================================================
    // following functions for draw the shapes during moving (they are growing), not only when end up
    //the take the "fake" name because they are temporal, then they are removed
    override fun fakeMoveTo(x: Float, y: Float) {
        myFakePath.moveTo(x, y)
    }

    override fun addFakeRect(left: Float, top: Float, right: Float, bottom: Float) {
        myFakePath.addRect(left, top, right, bottom, Path.Direction.CW)
    }

    override fun addFakeOval(left: Float, top: Float, right: Float, bottom: Float) {
        myFakePath.addOval(left, top, right, bottom, Path.Direction.CW)
    }

    override fun resetFakePath() {
        myFakePath.reset()
    }
    //===================================================================================================


    override fun draw(canvas: Canvas) {
        canvas.drawPath(myFakePath, myPaint)
        path_color_List.forEach {(path,color)->
            myPaint.setColor(color)
            canvas.drawPath(path, myPaint)
        }
    }

    override fun setAlpha(alpha: Int) {
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

}
