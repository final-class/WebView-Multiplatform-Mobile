package com.final_class.webview_multiplatform_mobile.webview.settings.android.activity_height

/**
 * @param initialHeightPx the Custom Tab Activity's initial height in pixels.
 * @param heightResizeBehavior desired height behavior.
 **/
data class ActivityHeight(
    val initialHeightPx: Int,
    val heightResizeBehavior: HeightResizeBehavior? = null,
)
