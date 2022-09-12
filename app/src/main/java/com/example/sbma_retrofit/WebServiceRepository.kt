package com.example.sbma_retrofit

class WebServiceRepository() {
    private val call = DemoApi.service

    suspend fun getHits(president: President) = call.test(
        "query", "json", "search", president.name
    )
}