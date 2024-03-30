package com.final_class.webview_multiplatform_mobile.webview.settings.ios

import androidx.compose.ui.graphics.Color
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.dismiss_button_style.DismissButtonStyle

data class IosSettings(
    var barCollapsingEnabled: Boolean? = null,
    var entersReaderIfAvailable: Boolean? = null,
    var dismissButtonStyle: DismissButtonStyle? = null,
    var preferredBarTintColor: Color? = null,
    var preferredControlTintColor: Color? = null,
) : IosWebViewModifier {
    override fun provide(): IosSettings = this
}
