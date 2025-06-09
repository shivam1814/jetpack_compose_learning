package com.compose.learn.philipp.practice

interface Paginator<Key, Item> {

    suspend fun loadNextItem()

    fun reset()

}