package com.choala.network.util

object UrlHelper {
    fun getIdInUrl(url: String?): Int? {
        return url?.split("/")?.last()?.toInt()
    }
}
