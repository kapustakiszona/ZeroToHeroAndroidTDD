package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {


            inputEditText.addTextChangedListener{
                actionButton.isEnabled = it?.length!! >= 3
            }

            actionButton.setOnClickListener {
                val text = inputEditText.text
                titleTextView.text = text
                inputEditText.text?.clear()
            }

        }
    }

}