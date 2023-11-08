package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)


        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = ProgressBar.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                textView.visibility = TextView.VISIBLE
                button.isEnabled = true
                progressBar.visibility = ProgressBar.INVISIBLE
            }, 3500)
        }
    }

}