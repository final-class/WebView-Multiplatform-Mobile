package com.final_class.webview_multiplatform_mobile.webview.controller

import androidx.compose.runtime.State
import com.final_class.webview_multiplatform_mobile.webview.controller.state.WebViewCommand
import kotlin.properties.ReadOnlyProperty

/**
 * Created by Dmitry Aleksandrovich on 30.03.2024
 **/
interface WebViewController : ReadOnlyProperty<Nothing?, WebViewController> {

    /** Open in application **/
    fun open(url: String)

    /** Open in external browser **/
    fun openInExternalBrowser(url: String)
}

internal interface InternalWebViewController : WebViewController {
    val webViewCommand: State<WebViewCommand>
    fun consume()
}
