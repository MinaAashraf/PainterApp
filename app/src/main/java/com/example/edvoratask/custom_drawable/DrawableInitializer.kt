package com.example.edvoratask.custom_drawable

import android.graphics.Color
import android.graphics.Paint

class PaintFactory {

    companion object {
        fun create(): Paint {
            return Paint().apply {
                setAntiAlias(true)
                setDither(true)
                setStyle(Paint.Style.STROKE)
                setStrokeJoin(Paint.Join.BEVEL)
                setStrokeCap(Paint.Cap.ROUND)
                setStrokeWidth(12f)
                setColor(Color.RED)
            }
        }
    }
}