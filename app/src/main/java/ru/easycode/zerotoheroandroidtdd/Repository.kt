package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {
    suspend fun load(): LoadResult


    class Base(private val service: SimpleService, private val url: String) : Repository {

        override suspend fun load(): LoadResult {
            return try {
                val result = service.fetch(url = url)
                LoadResult.Success(data = result)
            } catch (e: Exception) {
                LoadResult.Error(e is UnknownHostException)
            }
        }
    }

}
