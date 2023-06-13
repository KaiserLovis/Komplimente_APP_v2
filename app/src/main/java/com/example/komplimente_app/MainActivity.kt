package com.example.komplimente_app

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val nouns = arrayOf("nose", "head", "hand", "heart", "smile", "mind", "soul", "voice", "eye", "left middle finger", "hair")
    private val particles = arrayOf("very", "absolutely", "truly", "completely", "totally", "definitely", "utterly", "remarkably", "incredibly", "positively", "unbelievably", "")
    private val adjectives = arrayOf("nice", "pretty", "amazing", "wonderful", "awesome", "fantastic", "excellent", "brilliant", "outstanding", "exceptional", "marvelous", "fabulous", "cheerful", "impressive", "epic", "inspiring")
    private var buttonClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton: ImageButton = findViewById(R.id.imageButton)
        val complimentTextView: TextView = findViewById(R.id.complimentTextView)
        val flyingImage: ImageView = findViewById(R.id.flyingImage)
        val flyingImageDino: ImageView = findViewById(R.id.flyingImageDino)

        complimentTextView.text = ""
        generateButton.setOnClickListener {
            val compliment = "Your ${nouns.random()} is ${particles.random()} ${adjectives.random()}."
            complimentTextView.text = compliment

            buttonClickCount++
            if (buttonClickCount == 7) {
                complimentTextView.visibility=android.view.View.GONE
                animateFlyingImage(flyingImage)
                complimentTextView.visibility=android.view.View.VISIBLE
            }
            if (buttonClickCount >= 12) {
                animateFlyingImage(flyingImageDino)
                buttonClickCount = 0
            }
        }
    }

    private fun animateFlyingImage(imageView: ImageView) {
        val parentWidth = (imageView.parent as android.view.ViewGroup).width
        val parentHeight = (imageView.parent as android.view.ViewGroup).height
        val startX = -imageView.width.toFloat()
        val startY = parentHeight.toFloat() - imageView.height.toFloat()
        val endX = parentWidth.toFloat() / 2f - imageView.width.toFloat() / 2f
        val endY = parentHeight.toFloat() / 2f - imageView.height.toFloat() / 2f

        val animator = ObjectAnimator.ofFloat(imageView, "translationX", startX, endX)
        animator.duration = 1000
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                imageView.visibility = ImageView.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                imageView.visibility = ImageView.INVISIBLE
                imageView.translationX = startX
            }
        })
        animator.start()
    }
}
//mm
