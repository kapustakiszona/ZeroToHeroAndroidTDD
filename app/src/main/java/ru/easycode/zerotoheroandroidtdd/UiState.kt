package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, button: Button, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            progressBar.visibility = ProgressBar.VISIBLE
            button.isEnabled = false
            textView.visibility = TextView.INVISIBLE
        }
    }

    data class ShowData(val text: String) : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            progressBar.visibility = ProgressBar.GONE
            textView.visibility = TextView.VISIBLE
            textView.text = text
            button.isEnabled = true
        }

    }

}
