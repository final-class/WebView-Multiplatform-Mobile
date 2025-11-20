package com.final_class.webview_multiplatform_mobile.webview.controller.state

/**
 * Created by Dmitry Aleksandrovich on 30.03.2024
 **/
sealed interface WebViewCommand {
    data object Idle : WebViewCommand
    data class Open(val url: String, val openInExternalBrowser: Boolean) : WebViewCommand
}
