package com.example.edvoratask.main_ui

import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import com.example.edvoratask.R
import com.example.edvoratask.shapes_drawing.*


class Auxiliary(val mainView: Contract.ViewInterface, val myDrawable: Contract.DrawableInterface) :
    Contract.AuxiliaryInterface {
    var drawer: ShapeDrawer = HandDrawing()
    val context = (mainView as MainActivity)
    override fun onIconClick(v: View, toolsIcons: List<View>, colorsIcons: List<View>) {
        when (v.id) {
            R.id.pencil -> {
                drawer = HandDrawing()
            }
            R.id.arrow -> {
                drawer = ArrowDrawer()
            }
            R.id.rectangle -> {
                drawer = RectangleDrawing()
            }
            R.id.ellipse -> {
                drawer = OvalDrawer()
            }
            R.id.color_picker -> {
                mainView.setColorsPalletVisibility()
            }
            R.id.red ->
                myDrawable.setPaintColor(context.resources.getColor(R.color.red))
            R.id.green ->
                myDrawable.setPaintColor(context.resources.getColor(R.color.green))
            R.id.blue ->
                myDrawable.setPaintColor(context.resources.getColor(R.color.blue))
            R.id.black ->
                myDrawable.setPaintColor(context.resources.getColor(R.color.black))

        }
        handleSelectedItemHover(v, toolsIcons, colorsIcons)
    }

    private fun handleSelectedItemHover(
        view: View,
        toolsIcons: List<View>,
        colorsIcons: List<View>
    ) {
        if (view in toolsIcons) {
            toolsIcons.forEach {
                mainView.setSelectedItemHover(it, Color.DKGRAY, Color.TRANSPARENT)
            }
            mainView.setSelectedItemHover(view, R.color.black, R.drawable.rounded_rect)
        } else if (view in colorsIcons){
           mainView.setColorsPalletVisibility()
        }

    }


    override fun onTouchHandler(event: MotionEvent) {
        drawer.x = event.x
        drawer.y = event.y
        drawer.draw(event, myDrawable)
    }
}