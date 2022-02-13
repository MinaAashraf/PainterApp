package com.example.edvoratask.main_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.core.view.children
import androidx.core.view.isVisible
import com.example.edvoratask.custom_drawable.MyDrawable
import com.example.edvoratask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnTouchListener, View.OnClickListener,

    Contract.ViewInterface {
    private lateinit var binding: ActivityMainBinding
    private var isShow: Boolean = false
    private lateinit var auxInterface: Contract.AuxiliaryInterface
    private lateinit var myDrawable: MyDrawable

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //take instance of my custom drawable class
        myDrawable = MyDrawable()

        // Auxiliary is a helper class for the Ui logic
        auxInterface = Auxiliary(this, myDrawable)

        //set myDrawable instance as background for the 'drawingView' view
        binding.drawingView.setBackgroundDrawable(myDrawable)

        // listen on Touch Event for drawing
        binding.drawingView.setOnTouchListener(this)

        // listen on all the icon click events
        listenOnClickEvents()
    }


    override fun onTouch(v: View, event: MotionEvent): Boolean {
        auxInterface.onTouchHandler(event)
        binding.drawingView.invalidate()
        return true;
    }

    override fun onClick(v: View) {
        auxInterface.onIconClick(
            v,
            binding.toolsBarLayout.children.toList(),
            binding.colorsLayout.children.toList()
        )
    }


    override fun setSelectedItemHover(v: View, color: Int, backGDrawable: Int) {
        (v as ImageView).setColorFilter(color)
        v.setBackgroundResource(backGDrawable)
    }

    //set colors pallet visibility
    override fun setColorsPalletVisibility() {
        isShow = !isShow
        binding.colorsLayout.isVisible = isShow
        animateColorPallet()
    }

    fun animateColorPallet() {
        val transition = if (isShow) 35f else -35f
        binding.colorsLayout.animate().translationYBy(transition).setDuration(300)
    }

    fun listenOnClickEvents() {
        binding.pencil.setOnClickListener(this)
        binding.arrow.setOnClickListener(this)
        binding.rectangle.setOnClickListener(this)
        binding.ellipse.setOnClickListener(this)
        binding.colorPicker.setOnClickListener(this)
        binding.red.setOnClickListener(this)
        binding.green.setOnClickListener(this)
        binding.blue.setOnClickListener(this)
        binding.black.setOnClickListener(this)
    }

}
