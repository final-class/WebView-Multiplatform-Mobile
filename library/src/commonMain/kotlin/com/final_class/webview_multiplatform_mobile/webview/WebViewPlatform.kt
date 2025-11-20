package com.final_class.webview_multiplatform_mobile.webview

import androidx.compose.runtime.Composable
import com.final_class.webview_multiplatform_mobile.platform.WebViewPlatformImpl
import com.final_class.webview_multiplatform_mobile.webview.controller.InternalWebViewController
import com.final_class.webview_multiplatform_mobile.webview.controller.WebViewController
import com.final_class.webview_multiplatform_mobile.webview.controller.state.WebViewCommand
import com.final_class.webview_multiplatform_mobile.webview.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.webview.settings.android.AndroidWebViewModifier
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.IosSettings
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.IosWebViewModifier

/**
 * @param webViewController is needed to manage the launching of WebView
 * @param androidSettings settings for Android
 * @param iosSettings settings for iOS (The settings are not applied when the openInExternalBrowser value is set to true)
 * **/
@Composable
fun WebViewPlatform(
    webViewController: WebViewController,
    androidSettings: AndroidWebViewModifier = AndroidSettings(),
    iosSettings: IosWebViewModifier = IosSettings(),
) {
    val internalController = webViewController as InternalWebViewController

    when (val state = internalController.webViewCommand.value) {
        is WebViewCommand.Idle -> return
        is WebViewCommand.Open -> OpenWebView(state.url, state.openInExternalBrowser, androidSettings, iosSettings)
    }

    internalController.consume()
}

@Composable
internal fun OpenWebView(
    url: String,
    openInExternalBrowser: Boolean = false,
    androidSettings: AndroidWebViewModifier = AndroidSettings(),
    iosSettings: IosWebViewModifier = IosSettings(),
) {
    WebViewPlatformImpl(
        url = url,
        openInExternalBrowser = openInExternalBrowser,
        androidSettings = androidSettings.provide(),
        iosSettings = iosSettings.provide(),
    )
}
