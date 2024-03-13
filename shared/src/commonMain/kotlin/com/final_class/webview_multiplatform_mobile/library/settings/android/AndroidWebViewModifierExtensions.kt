package com.final_class.webview_multiplatform_mobile.library.settings.android

import com.final_class.webview_multiplatform_mobile.library.settings.android.activity_height.ActivityHeight
import com.final_class.webview_multiplatform_mobile.library.settings.android.android_scheme_colors.ColorSchemeParams
import com.final_class.webview_multiplatform_mobile.library.settings.android.animation.AndroidAnimations
import com.final_class.webview_multiplatform_mobile.library.settings.android.close_button_position.CloseButtonPosition
import com.final_class.webview_multiplatform_mobile.library.settings.android.scheme.AndroidScheme
import com.final_class.webview_multiplatform_mobile.library.settings.android.share.ShareState

/**
 * Created by Dmitry Aleksandrovich on 29.02.2024
 **/
fun AndroidWebViewModifier.showTitle(show: Boolean): AndroidWebViewModifier {
    return this.then(their = this).apply { this.showTitle = show }
}

fun AndroidWebViewModifier.urlBarHidingEnabled(enabled: Boolean): AndroidWebViewModifier {
    return this.then(their = this).apply { this.urlBarHidingEnabled = enabled }
}

fun AndroidWebViewModifier.shareState(shareState: ShareState): AndroidWebViewModifier {
    return this.then(their = this).apply { this.shareState = shareState }
}

fun AndroidWebViewModifier.instantAppsEnabled(enabled: Boolean): AndroidWebViewModifier {
    return this.then(their = this).apply { this.instantAppsEnabled = enabled }
}

fun AndroidWebViewModifier.toolbarCornerRadiusDp(radius: Int): AndroidWebViewModifier {
    return this.then(their = this).apply { this.toolbarCornerRadiusDp = radius }
}

fun AndroidWebViewModifier.activityHeight(activityHeight: ActivityHeight): AndroidWebViewModifier {
    return this.then(their = this).apply { this.activityHeight = activityHeight }
}

fun AndroidWebViewModifier.closeButtonPosition(closeButtonPosition: CloseButtonPosition): AndroidWebViewModifier {
    return this.then(their = this).apply { this.closeButtonPosition = closeButtonPosition }
}

fun AndroidWebViewModifier.startAnimations(animations: AndroidAnimations): AndroidWebViewModifier {
    return this.then(their = this).apply { this.startAnimation = animations }
}

fun AndroidWebViewModifier.exitAnimations(animations: AndroidAnimations): AndroidWebViewModifier {
    return this.then(their = this).apply { this.exitAnimation = animations }
}

fun AndroidWebViewModifier.scheme(scheme: AndroidScheme): AndroidWebViewModifier {
    return this.then(their = this).apply { this.scheme = scheme }
}

fun AndroidWebViewModifier.defaultColorSchemeParams(colorSchemeParams: ColorSchemeParams): AndroidWebViewModifier {
    return this.then(their = this).apply { this.defaultColorSchemeParams = colorSchemeParams }
}

fun AndroidWebViewModifier.darkColorSchemeParams(colorSchemeParams: ColorSchemeParams): AndroidWebViewModifier {
    return this.then(their = this).apply { this.darkColorSchemeParams = colorSchemeParams }
}