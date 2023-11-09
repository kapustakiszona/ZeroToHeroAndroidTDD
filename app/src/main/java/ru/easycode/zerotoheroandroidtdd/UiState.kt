package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {
    fun apply(textView: TextView, button: Button, progressBar: ProgressBar)
    object ShowData : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            progressBar.visibility = ProgressBar.GONE
            button.isEnabled = true
            textView.visibility = TextView.VISIBLE
        }

    }

    object ShowProgress : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            progressBar.visibility = ProgressBar.VISIBLE
            button.isEnabled = false
            textView.visibility = TextView.INVISIBLE
        }

    }

}
