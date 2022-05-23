package com.example.vertitube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView

class MainActivity : AppCompatActivity() {

    lateinit var webv: WebView
    lateinit var URL:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webv = findViewById(R.id.webview)
        URL  = "https://www.youtube.com"

        val ajustesweb = webv.settings
        ajustesweb.javaScriptEnabled = true
        webv.loadUrl(URL)


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event!!.action === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webv.canGoBack()) {
                        webv.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}