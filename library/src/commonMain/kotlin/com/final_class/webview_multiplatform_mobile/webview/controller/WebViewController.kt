package com.final_class.webview_multiplatform_mobile.webview.controller

import androidx.compose.runtime.State
import com.final_class.webview_multiplatform_mobile.webview.controller.state.WebViewState
import kotlin.properties.ReadOnlyProperty

/**
 * Created by Dmitry Aleksandrovich on 30.03.2024
 **/
interface WebViewController : ReadOnlyProperty<Nothing?, WebViewController> {

    val webViewState: State<WebViewState>

    /** Open in application **/
    fun open(url: String)

    /** Open in external browser **/
    fun openInExternalBrowser(url: String)

    fun consume()
}