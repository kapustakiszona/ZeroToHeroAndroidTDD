package ru.easycode.zerotoheroandroidtdd

interface LoadResult {
    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Success(private val data: SimpleResponse) : LoadResult {

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(data.text))
        }

    }

    data class Error(private val noConnection: Boolean) : LoadResult {

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(text = if (noConnection) NO_CONNECTION_ERROR else OTHER_ERROR))
        }

    }

    companion object {
        private const val NO_CONNECTION_ERROR = "No internet connection"
        private const val OTHER_ERROR = "Something went wrong"
    }
}
