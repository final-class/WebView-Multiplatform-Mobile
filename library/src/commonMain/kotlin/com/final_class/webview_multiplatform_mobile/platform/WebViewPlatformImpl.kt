package com.final_class.webview_multiplatform_mobile.platform

import androidx.compose.runtime.Composable
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosSettings

@Composable
internal expect fun WebViewPlatformImpl(
    url: String,
    openInExternalBrowser: Boolean,
    androidSettings: AndroidSettings,
    iosSettings: IosSettings,
)