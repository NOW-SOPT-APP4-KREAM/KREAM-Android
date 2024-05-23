package org.sopt.kream.util

fun <T> chunkList(list: List<T>, chunkSize: Int): List<List<T>> = list.chunked(chunkSize)