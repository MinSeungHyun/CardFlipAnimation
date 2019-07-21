package com.seunghyun.cardflipanimation

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val distance = 8000
        val scale = resources.displayMetrics.density * distance
        front.cameraDistance = scale
        back.cameraDistance = scale

        var isBackVisible = false

        front.setOnClickListener {
            isBackVisible = if (!isBackVisible) {
                flipView(front, back)
                true
            } else {
                flipView(back, front)
                false
            }

        }
    }

    private fun flipView(front: View, back: View) {
        val flipOutSet = AnimatorInflater.loadAnimator(this, R.animator.flip_out) as AnimatorSet
        val flipInSet = AnimatorInflater.loadAnimator(this, R.animator.flip_in) as AnimatorSet
        flipOutSet.setTarget(front)
        flipInSet.setTarget(back)
        flipOutSet.start()
        flipInSet.start()
    }
}
