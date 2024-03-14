package com.final_class.webview_multiplatform_mobile.library.settings.android

import com.final_class.webview_multiplatform_mobile.library.settings.android.activity_height.ActivityHeight
import com.final_class.webview_multiplatform_mobile.library.settings.android.android_scheme_colors.ColorSchemeParams
import com.final_class.webview_multiplatform_mobile.library.settings.android.animation.AndroidAnimations
import com.final_class.webview_multiplatform_mobile.library.settings.android.close_button_position.CloseButtonPosition
import com.final_class.webview_multiplatform_mobile.library.settings.android.scheme.AndroidScheme
import com.final_class.webview_multiplatform_mobile.library.settings.android.share.ShareState

data class AndroidSettings(
    var showTitle: Boolean? = null,
    var urlBarHidingEnabled: Boolean? = null,
    var shareState: ShareState? = null,
    var instantAppsEnabled: Boolean? = null,
    var toolbarCornerRadiusDp: Int? = null,
    var activityHeight: ActivityHeight? = null,
    var closeButtonPosition: CloseButtonPosition? = null,
    var exitAnimation: AndroidAnimations? = null,
    var startAnimation: AndroidAnimations? = null,
    var scheme: AndroidScheme? = null,
    var defaultColorSchemeParams: ColorSchemeParams? = null,
    var darkColorSchemeParams: ColorSchemeParams? = null,
) : AndroidWebViewModifier {

    override fun provide(): AndroidSettings = this
}
