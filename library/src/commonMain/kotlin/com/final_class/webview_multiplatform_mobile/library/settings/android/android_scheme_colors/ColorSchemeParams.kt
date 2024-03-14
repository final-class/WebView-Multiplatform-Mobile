package com.final_class.webview_multiplatform_mobile.library.settings.android.android_scheme_colors

import androidx.compose.ui.graphics.Color

/**
 * @param toolbarColor sets the toolbar color. On Android L and above, this color is also applied to the status bar.
 * To ensure good contrast between status bar icons and the background,
 * Custom Tab implementations may use SYSTEM_UI_FLAG_LIGHT_STATUS_BAR on Android M and above,
 * and use a darkened color for the status bar on Android L.
 * @param secondaryToolbarColor sets the color of the secondary toolbar.
 * @param navigationBarColor sets the navigation bar color. Has no effect on API versions below L.
 * To ensure good contrast between navigation bar icons and the background,
 * Custom Tab implementations may use SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR on Android O and above,
 * and darken the provided color on Android L-N.
 * @param navigationBarDividerColor sets the navigation bar divider color. Has no effect on API versions below P.
 **/
data class ColorSchemeParams(
    val toolbarColor: Color? = null,
    val secondaryToolbarColor: Color? = null,
    val navigationBarColor: Color? = null,
    val navigationBarDividerColor: Color? = null
)
