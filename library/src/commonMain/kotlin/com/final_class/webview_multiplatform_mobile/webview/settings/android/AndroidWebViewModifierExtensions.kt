package com.final_class.webview_multiplatform_mobile.webview.settings.android

import com.final_class.webview_multiplatform_mobile.webview.settings.android.activity_height.ActivityHeight
import com.final_class.webview_multiplatform_mobile.webview.settings.android.android_scheme_colors.ColorSchemeParams
import com.final_class.webview_multiplatform_mobile.webview.settings.android.animation.AndroidAnimations
import com.final_class.webview_multiplatform_mobile.webview.settings.android.close_button_position.CloseButtonPosition
import com.final_class.webview_multiplatform_mobile.webview.settings.android.scheme.AndroidScheme
import com.final_class.webview_multiplatform_mobile.webview.settings.android.share.ShareState

/**
 * @param show sets whether the title should be shown in the custom tab.
 **/
fun AndroidWebViewModifier.showTitle(show: Boolean): AndroidWebViewModifier {
    return this.then().apply { this.showTitle = show }
}

/**
 * @param enabled set whether the url bar should hide as the user scrolls down on the page.
 **/
fun AndroidWebViewModifier.urlBarHidingEnabled(enabled: Boolean): AndroidWebViewModifier {
    return this.then().apply { this.urlBarHidingEnabled = enabled }
}

/**
 * @param shareState sets the share state that should be applied to the custom tab.
 **/
fun AndroidWebViewModifier.shareState(shareState: ShareState): AndroidWebViewModifier {
    return this.then().apply { this.shareState = shareState }
}

/**
 * @param enabled sets whether Instant Apps is enabled for this Custom Tab.
 **/
fun AndroidWebViewModifier.instantAppsEnabled(enabled: Boolean): AndroidWebViewModifier {
    return this.then().apply { this.instantAppsEnabled = enabled }
}

/**
 * @param radius sets the toolbar's top corner radii in dp.
 **/
fun AndroidWebViewModifier.toolbarCornerRadiusDp(radius: Int): AndroidWebViewModifier {
    return this.then().apply { this.toolbarCornerRadiusDp = radius }
}

/**
 * @param activityHeight sets the Custom Tab Activity's initial height in pixels and the desired resize behavior.
 **/
fun AndroidWebViewModifier.activityHeight(activityHeight: ActivityHeight): AndroidWebViewModifier {
    return this.then().apply { this.activityHeight = activityHeight }
}

/**
 * @param closeButtonPosition sets the position of the close button.
 **/
fun AndroidWebViewModifier.closeButtonPosition(closeButtonPosition: CloseButtonPosition): AndroidWebViewModifier {
    return this.then().apply { this.closeButtonPosition = closeButtonPosition }
}

/**
 * @param animations sets the start animations.
 **/
fun AndroidWebViewModifier.startAnimations(animations: AndroidAnimations): AndroidWebViewModifier {
    return this.then().apply { this.startAnimation = animations }
}

/**
 * @param animations Sets the exit animations.
 **/
fun AndroidWebViewModifier.exitAnimations(animations: AndroidAnimations): AndroidWebViewModifier {
    return this.then().apply { this.exitAnimation = animations }
}

/**
 * @param scheme Sets the color scheme that should be applied to the user interface in the custom tab.
 **/
fun AndroidWebViewModifier.scheme(scheme: AndroidScheme): AndroidWebViewModifier {
    return this.then().apply { this.scheme = scheme }
}

/**
 * @param colorSchemeParams sets the default CustomTabColorSchemeParams.
 * This will set a default color scheme that applies when no AndroidScheme
 * specified for current color scheme via scheme.
 **/
fun AndroidWebViewModifier.defaultColorSchemeParams(colorSchemeParams: ColorSchemeParams): AndroidWebViewModifier {
    return this.then().apply { this.defaultColorSchemeParams = colorSchemeParams }
}

/**
 * @param colorSchemeParams sets the dark CustomTabColorSchemeParams.
 *  * This will set a dark color scheme that applies when AndroidScheme.Dark
 *  * specified for current color scheme via scheme.
 **/
fun AndroidWebViewModifier.darkColorSchemeParams(colorSchemeParams: ColorSchemeParams): AndroidWebViewModifier {
    return this.then().apply { this.darkColorSchemeParams = colorSchemeParams }
}

internal fun AndroidWebViewModifier.then(): AndroidSettings = if (this is AndroidSettings) this else AndroidSettings()