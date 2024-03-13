package com.final_class.webview_multiplatform_mobile.library.settings.ios

import androidx.compose.ui.graphics.Color
import com.final_class.webview_multiplatform_mobile.library.settings.ios.dismiss_button_style.DismissButtonStyle

/**
 * Created by Dmitry Aleksandrovich on 04.03.2024
 **/
data class IosSettings(
    var barCollapsingEnabled: Boolean? = null,
    var entersReaderIfAvailable: Boolean? = null,
    var dismissButtonStyle: DismissButtonStyle? = null,
    var preferredBarTintColor: Color? = null,
    var preferredControlTintColor: Color? = null,
) : IosWebViewModifier {
    override fun provide(): IosSettings = this
}
