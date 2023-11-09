package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(private val livedata: MutableLiveData<UiState> = SingleLiveEvent()) :
        LiveDataWrapper {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            livedata.value?.let {
                bundleWrapper.save(it)
            }

        }

        override fun update(value: UiState) {
            livedata.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return livedata
        }
    }
}
