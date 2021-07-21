package com.gamapp.blurCardViewProject

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.gamapp.blurcardview.BlurCardView

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(-1, -1)
        }
        val image2 = ImageView(this).apply {
            this.layoutParams = FrameLayout.LayoutParams(200,200).apply {
                gravity = Gravity.CENTER
            }
            setImageResource(R.drawable.ic_launcher_background)
        }
        val image3 = ImageView(this).apply {
            this.layoutParams = FrameLayout.LayoutParams(1200,1200).apply {
                gravity = Gravity.CENTER
            }
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImageResource(R.drawable.photo)
        }
        val blurCardView = BlurCardView(this).apply {
            layoutParams = FrameLayout.LayoutParams(1000,300).apply {
                gravity = Gravity.CENTER
                topMargin = 200
            }
            addView(AppCompatTextView(this@MainActivity).apply {
                layoutParams = FrameLayout.LayoutParams(-1,-1).apply {
                    this.gravity = Gravity.CENTER
                    setPadding(40,40,40,40)
                }
                text = "BlurCardView"
                setLines(1)
                gravity = Gravity.CENTER
                setAutoSizeTextTypeUniformWithConfiguration(1,200,1,1)
                setTextColor(Color.WHITE)

            })
        }
        frameLayout.addView(image3)
        frameLayout.addView(blurCardView)
        frameLayout.addView(image2)
        blurCardView.apply {
            cardElevation = 200f
            radius = 50f
        }
        setContentView(frameLayout)
    }
}