package com.caro.romeocaro.presentation.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()

}