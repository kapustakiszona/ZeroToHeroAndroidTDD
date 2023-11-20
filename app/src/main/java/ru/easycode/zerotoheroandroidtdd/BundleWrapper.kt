package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Mutable : Save, Restore

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    class Base(private val bundle: Bundle) : Mutable {
        override fun save(uiState: UiState) {
            bundle.putSerializable("key", uiState)
        }

        override fun restore(): UiState {
            return bundle.getSerializable("key") as UiState
        }
    }

}
