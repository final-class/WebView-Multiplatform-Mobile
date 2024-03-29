package com.final_class.webview_multiplatform_mobile.library

import androidx.compose.runtime.Composable
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidWebViewModifier
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosSettings
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosWebViewModifier
import com.final_class.webview_multiplatform_mobile.platform.WebViewPlatformImpl

/**
 * @param url url to open WebView
 * @param openInExternalBrowser open in external browser
 * @param androidSettings settings for Android
 * @param iosSettings settings for iOS (The settings are not applied when the openInExternalBrowser value is set to true)
 * **/
@Composable
fun WebViewPlatform(
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