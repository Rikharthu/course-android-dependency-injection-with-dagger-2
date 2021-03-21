package com.techyourchance.dagger2course.networking

import com.techyourchance.dagger2course.Constants

class UrlProvider {

    fun getBaseUrl(): String {
        return Constants.BASE_URL
    }

    fun getBaseUrl2(): String {
        return "Base Url 2"
    }
}