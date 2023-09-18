package com.example.giphy

import com.example.giphy.network.GiphyApi
import com.example.giphy.network.RetrofitClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*


class ExampleUnitTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun addition_isCorrect() = runTest {
        val retrofit = RetrofitClient.getClient()
        val api = retrofit.create(GiphyApi::class.java)

        val res = api.searchGif("test", 0)

        println("RESULT: ")
        println(res)

        assertEquals(4, 2 + 2)
    }
}