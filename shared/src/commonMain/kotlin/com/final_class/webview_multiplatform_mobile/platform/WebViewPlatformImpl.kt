package com.final_class.webview_multiplatform_mobile.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosSettings

/**
 * Created by Dmitry Aleksandrovich on 25.02.2024
 **/
@Composable
internal expect fun WebViewPlatformImpl(
    modifier: Modifier = Modifier,
    url: String,
    androidSettings: AndroidSettings,
    iosSettings: IosSettings,
    onClose: () -> Unit
)