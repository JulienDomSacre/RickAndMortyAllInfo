package com.choala.network.util

object UrlHelper {
    fun getIdInUrl(url: String?): Int? {
        if (url?.isNotEmpty()!!)
            return url.split("/").last().toInt()
        return 1
    }
}
