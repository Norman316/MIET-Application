package com.example.miet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class More : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        webView = findViewById(R.id.myWebView)
        val webSettings: WebSettings = webView.settings
        webSettings.builtInZoomControls = true
        webSettings.javaScriptEnabled = true

        webView.webViewClient = Callback()
        webView.loadUrl("file:///android_asset/index.html")
    }

    inner class Callback : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }


}