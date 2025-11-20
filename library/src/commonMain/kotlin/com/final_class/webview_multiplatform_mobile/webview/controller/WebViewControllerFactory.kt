package com.final_class.webview_multiplatform_mobile.webview.controller

object WebViewControllerFactory {
    /** Returns a new controller instance. */
    fun create(): WebViewController = WebViewControllerImpl()
}
