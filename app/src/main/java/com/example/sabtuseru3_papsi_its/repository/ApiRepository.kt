package com.example.sabtuseru3_papsi_its.repository

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class ApiRepository {

    fun doRequestAsync(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }

}