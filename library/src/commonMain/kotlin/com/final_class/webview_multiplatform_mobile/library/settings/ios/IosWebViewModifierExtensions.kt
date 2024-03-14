package com.final_class.webview_multiplatform_mobile.library.settings.ios

import androidx.compose.ui.graphics.Color
import com.final_class.webview_multiplatform_mobile.library.settings.ios.dismiss_button_style.DismissButtonStyle


/**
 * @param enabled enabled bar collapsing.
 **/
fun IosWebViewModifier.barCollapsingEnabled(enabled: Boolean): IosWebViewModifier {
    return this.then().apply { this.barCollapsingEnabled = enabled }
}

/**
 * @param entersReader a value that specifies whether Safari should enter Reader mode, if it is available.
 * **/
fun IosWebViewModifier.entersReaderIfAvailable(entersReader: Boolean): IosWebViewModifier {
    return this.then().apply { this.entersReaderIfAvailable = entersReader }
}

/**
 * @param buttonStyle sets dismiss button style.
 * **/
fun IosWebViewModifier.dismissButtonStyle(buttonStyle: DismissButtonStyle): IosWebViewModifier {
    return this.then().apply { this.dismissButtonStyle = buttonStyle }
}

/**
 * @param color the color to tint the background of the navigation bar and the toolbar.
 * **/
fun IosWebViewModifier.preferredBarTintColor(color: Color): IosWebViewModifier {
    return this.then().apply { this.preferredBarTintColor = color }
}

/**
 * @param color the color to tint the control buttons on the navigation bar and the toolbar.
 * **/
fun IosWebViewModifier.preferredControlTintColor(color: Color): IosWebViewModifier {
    return this.then().apply { this.preferredControlTintColor = color }
}

internal fun IosWebViewModifier.then(): IosSettings = if (this is IosSettings) this else IosSettings()