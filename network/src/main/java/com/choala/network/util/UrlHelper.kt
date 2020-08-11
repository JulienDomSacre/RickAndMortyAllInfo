package com.choala.network.util

object UrlHelper {
    fun getIdInUrl(url: String): Int {
        return if (url.isNotEmpty())
            url.split("/").last().toInt()
        else
            1
    }
}
