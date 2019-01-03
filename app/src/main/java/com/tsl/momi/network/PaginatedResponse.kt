package com.tsl.momi.network

import android.net.UrlQuerySanitizer

data class PaginatedResponse<Any> (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Any>){

    fun isFirstPage(): Boolean {
        return previous == null
    }

    fun isLastPage(): Boolean {
        return next == null
    }

    fun getNext(): Int? {
        return getPageParameter(next)
    }

    fun getPrevious(): Int? {
        return getPageParameter(previous)
    }

    private fun getPageParameter(url: String?): Int? {
        if (url == null || url.isEmpty()) {
            return null
        }

        val sanitizer = UrlQuerySanitizer(url)
        val value = sanitizer.getValue("page")
        return Integer.parseInt(value)
    }
}