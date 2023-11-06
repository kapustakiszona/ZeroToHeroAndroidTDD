package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var decrementButton: Button
    private lateinit var incrementButton: Button
    private lateinit var textView: TextView

    private val count = Count.Base(step = 2, min = 0, max = 4)
    private lateinit var state: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)

        state = count.initial(textView.text.toString())
        state.apply(textView, decrementButton, incrementButton)

        incrementButton.setOnClickListener {
            state = count.increment(number = textView.text.toString())
            state.apply(textView, decrementButton, incrementButton)
        }

        decrementButton.setOnClickListener {
            state = count.decrement(number = textView.text.toString())
            state.apply(textView, decrementButton, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("key", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable("key") as UiState
        state.apply(textView, decrementButton, incrementButton)
    }
}