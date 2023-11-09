package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModelFactory = MainViewModelFactory(LiveDataWrapper.Base(), Repository.Base())
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val button: Button = findViewById(R.id.actionButton)
        val textView: TextView = findViewById(R.id.titleTextView)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        button.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData().observe(this) {
            it.apply(textView, button, progressBar)
        }
    }
}