package com.example.komplimente_app

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val nouns = arrayOf("nose", "head", "hand", "heart", "smile", "mind", "soul", "voice")
    private val particles = arrayOf("very", "absolutely", "truly", "completely", "totally", "definitely", "utterly", "remarkably", "incredibly", "positively")
    private val adjectives = arrayOf("nice", "pretty", "amazing", "wonderful", "awesome", "fantastic", "excellent", "brilliant", "outstanding", "exceptional", "marvelous", "fabulous")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val generateButton: ImageButton = findViewById(R.id.imageButton)
        val complimentTextView: TextView = findViewById(R.id.complimentTextView)
        complimentTextView.setText("")
        generateButton.setOnClickListener {
            val compliment = "Your ${nouns.random()} is ${particles.random()} ${adjectives.random()}."
            complimentTextView.text = compliment
        }
    }
}
