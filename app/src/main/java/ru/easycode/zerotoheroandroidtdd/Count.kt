package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    class Base(private val max: Int, private val step: Int, private val min: Int) : Count {

        init {
            when {
                step < 1 -> {
                    throw IllegalStateException("step should be positive, but was $step")
                }

                max < 1 -> {
                    throw IllegalStateException("max should be positive, but was $max")
                }

                max < step -> {
                    throw IllegalStateException("max should be more than step")
                }

                max < min -> {
                    throw IllegalStateException("max should be more than min")
                }
            }
        }

        override fun initial(number: String): UiState {

            return when (number.toInt()) {
                max -> {
                    UiState.Max(text = number)
                }

                min -> {
                    UiState.Min(text = number)
                }

                else -> {
                    UiState.Base(text = number)
                }
            }
        }

        override fun increment(number: String): UiState {
            val digitInt = number.toInt()
            val result = step + digitInt
            return initial(result.toString())
        }

        override fun decrement(number: String): UiState {
            val digitInt = number.toInt()
            val result = digitInt - step
            return initial(result.toString())

        }

    }
}