package com.works.html

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {
    lateinit var webViewNews : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webViewNews = findViewById(R.id.webViewNews)

        val href = intent.getStringExtra("href")
        webViewNews.loadUrl(href!!) // nullable olduğu için zorladım
    }
}