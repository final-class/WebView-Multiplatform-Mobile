package com.final_class.webview_multiplatform_mobile.webview.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

/**
 * Created by Dmitry Aleksandrovich on 30.03.2024
 **/
@Composable
fun rememberWebViewController(): WebViewController {
    return remember { WebViewControllerFactory.create() }
}
