package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(button: Button, textView: TextView, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            button.isEnabled = false
            progressBar.visibility = ProgressBar.VISIBLE
            textView.visibility = TextView.INVISIBLE
        }

    }

    object ShowData : UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            button.isEnabled = true
            progressBar.visibility = ProgressBar.INVISIBLE
            textView.visibility = TextView.VISIBLE
        }

    }

}
