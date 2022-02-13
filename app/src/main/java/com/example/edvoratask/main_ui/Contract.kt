package com.example.edvoratask.main_ui

import android.graphics.Path
import android.view.MotionEvent
import android.view.View

interface Contract {
    interface AuxiliaryInterface {
        fun onIconClick(v: View, toolsIcons: List<View>, colorsIcons: List<View>)
        fun onTouchHandler(event: MotionEvent)
    }

    interface ViewInterface {
        fun setSelectedItemHover(v: View, color: Int, backGDrawable: Int)
        fun setColorsPalletVisibility()
    }

    interface DrawableInterface {
        fun setPaintColor(color: Int)

        fun moveTo(x: Float, y: Float)

        fun lineTo(x: Float, y: Float)

        fun addOval(left: Float, top: Float, right: Float, bottom: Float)

        fun addRect(left: Float, top: Float, right: Float, bottom: Float)

        fun resetPath()

        fun fakeMoveTo(x: Float, y: Float)
        fun addFakeOval(left: Float, top: Float, right: Float, bottom: Float)
        fun addFakeRect(left: Float, top: Float, right: Float, bottom: Float)
        fun resetFakePath()

    }
}