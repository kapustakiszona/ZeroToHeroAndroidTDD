package ru.easycode.zerotoheroandroidtdd

import java.io.Serializable

interface Count : Serializable {

    fun increment(number: String): String

    class Base(var step: Int) : Count {
        init {
            if (step < 1) {
                throw IllegalStateException("step should be positive, but was $step")
            }
        }

        override fun increment(number: String): String {
            step += number.toInt()
            return step.toString()
        }
    }

}

