package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Mutable : Update, Save, Observe

    interface Observe {
        fun liveData(): LiveData<UiState>
    }

    interface Update {
        fun update(value: UiState)
    }

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    class Base(private val liveData: MutableLiveData<UiState> = SingleLiveEvent()) : Mutable {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { uiState ->
                bundleWrapper.save(uiState)
            }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }


}
