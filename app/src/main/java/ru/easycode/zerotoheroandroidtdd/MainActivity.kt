package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private var state: State = State.Initial

    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var parentLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parentLayout = findViewById(R.id.rootLayout)
        button = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            state = State.Removed
            state.apply(parentLayout, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("key", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable("key", State::class.java) as State
        } else {
            savedInstanceState.getSerializable("key") as State
        }
        state.apply(parentLayout, textView)
    }

    interface State : Serializable {
        fun apply(parentLayout: LinearLayout, textView: TextView)

        object Initial : State {
            override fun apply(parentLayout: LinearLayout, textView: TextView) = Unit

        }

        object Removed : State {
            override fun apply(parentLayout: LinearLayout, textView: TextView) {
                parentLayout.removeView(textView)
            }

        }
    }
}