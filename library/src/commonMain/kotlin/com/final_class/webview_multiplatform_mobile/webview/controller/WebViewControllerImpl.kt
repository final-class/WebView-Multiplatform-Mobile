package com.final_class.webview_multiplatform_mobile.webview.controller

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.final_class.webview_multiplatform_mobile.webview.controller.state.WebViewCommand
import kotlin.reflect.KProperty

/**
 * Created by Dmitry Aleksandrovich on 30.03.2024
 **/
class WebViewControllerImpl internal constructor() : InternalWebViewController {

    private val _webViewCommand: MutableState<WebViewCommand> = mutableStateOf(WebViewCommand.Idle)
    override val webViewCommand: State<WebViewCommand> = _webViewCommand

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): WebViewController {
        return this
    }

    override fun open(url: String) {
        val verifiedUrl = verifyUrl(url = url)

        _webViewCommand.value = WebViewCommand.Open(url = verifiedUrl, openInExternalBrowser = false)
    }

    override fun openInExternalBrowser(url: String) {
        val verifiedUrl = verifyUrl(url = url)

        _webViewCommand.value = WebViewCommand.Open(url = verifiedUrl, openInExternalBrowser = true)
    }

    override fun consume() {
        _webViewCommand.value = WebViewCommand.Idle
    }

    private fun verifyUrl(url: String): String {
        if (url.isBlank()) throw IllegalArgumentException("url cannot be empty")

        return url.trim()
    }
}
