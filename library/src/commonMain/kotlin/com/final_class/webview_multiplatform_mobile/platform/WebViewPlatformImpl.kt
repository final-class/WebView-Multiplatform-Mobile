package com.final_class.webview_multiplatform_mobile.platform

import androidx.compose.runtime.Composable
import com.final_class.webview_multiplatform_mobile.webview.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.IosSettings

@Composable
internal expect fun WebViewPlatformImpl(
    url: String,
    openInExternalBrowser: Boolean,
    androidSettings: AndroidSettings,
    iosSettings: IosSettings,
)