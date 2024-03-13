package com.final_class.webview_multiplatform_mobile.library.settings.ios

import androidx.compose.ui.graphics.Color
import com.final_class.webview_multiplatform_mobile.library.settings.ios.dismiss_button_style.DismissButtonStyle


/**
 * Created by Dmitry Aleksandrovich on 29.02.2024
 **/
fun IosWebViewModifier.barCollapsingEnabled(enabled: Boolean): IosWebViewModifier {
    return this.then(their = this).apply { this.barCollapsingEnabled = enabled }
}

fun IosWebViewModifier.entersReaderIfAvailable(entersReader: Boolean): IosWebViewModifier {
    return this.then(their = this).apply { this.entersReaderIfAvailable = entersReader }
}

fun IosWebViewModifier.dismissButtonStyle(buttonStyle: DismissButtonStyle): IosWebViewModifier {
    return this.then(their = this).apply { this.dismissButtonStyle = buttonStyle }
}

fun IosWebViewModifier.preferredBarTintColor(color: Color): IosWebViewModifier {
    return this.then(their = this).apply { this.preferredBarTintColor = color }
}

fun IosWebViewModifier.preferredControlTintColor(color: Color): IosWebViewModifier {
    return this.then(their = this).apply { this.preferredControlTintColor = color }
}