package com.final_class.webview_multiplatform_mobile.webview.controller.state

/**
 * Created by Dmitry Aleksandrovich on 30.03.2024
 **/
sealed interface WebViewState {
    data object Close : WebViewState
    data class Open(val url: String, val openInExternalBrowser: Boolean) : WebViewState
}