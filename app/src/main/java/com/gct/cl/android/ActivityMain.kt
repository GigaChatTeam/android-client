package com.gct.cl.android

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast

class ActivityMain : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        binder()
    }


    @SuppressLint("SetTextI18n")
    private fun binder() {
        val button_addButton = findViewById<Button>(R.id.button_addButton)
        val button_addCustomWidget = findViewById<Button>(R.id.button_addCustomWidget)

        val layout = findViewById<LinearLayout>(R.id.testLayout)
        val scrollView = findViewById<ScrollView>(R.id.testScroll)

        val upButton = findViewById<Button>(R.id.upButton)
        val downButton = findViewById<Button>(R.id.downButton)

        upButton.setOnClickListener {
            scrollView.fullScroll(ScrollView.FOCUS_UP)
        }
        downButton.setOnClickListener {
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
        }

        button_addCustomWidget.setOnClickListener {
            val widget = ChannelMessageWidget(this, windowManager.defaultDisplay.width)

            widget.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )

            widget.setAvatar(
                BitmapFactory.decodeResource(
                    getResources(),
                    R.drawable.default_avatar
                )
            )

            widget.setText("ТекстТекст".repeat(count + 1))

            layout.addView(widget)
        }

        button_addButton.setOnClickListener {
            count++

            val button = Button(this)

            button.text = "Кнопка $count!"

            button.setOnClickListener {
                Toast.makeText(this, "Привет, $count", Toast.LENGTH_SHORT).show()
            }

            layout.addView(button)
        }
    }
}