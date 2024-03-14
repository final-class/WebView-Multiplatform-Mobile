package com.final_class.webview_multiplatform_mobile.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidWebViewModifier
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosSettings
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosWebViewModifier
import com.final_class.webview_multiplatform_mobile.platform.WebViewPlatformImpl

/**
 * Created by Dmitry Aleksandrovich on 29.02.2024
 **/
@Composable
fun WebViewPlatform(
    modifier: Modifier = Modifier,
    url: String,
    androidSettings: AndroidWebViewModifier = AndroidSettings(),
    iosSettings: IosWebViewModifier = IosSettings(),
    onClose: (() -> Unit)? = null
) {
    WebViewPlatformImpl(
        modifier = modifier,
        url = url,
        androidSettings = androidSettings.provide(),
        iosSettings = iosSettings.provide(),
        onClose = onClose
    )
}