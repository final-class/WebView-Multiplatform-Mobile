package com.final_class.webview_multiplatform_mobile.webview.settings.android.scheme

enum class AndroidScheme {
    /** Applies either a light or dark color scheme to the user interface in the custom tab depending on the user's system settings. **/
    System,

    /** Applies a light color scheme to the user interface in the custom tab. **/
    Light,

    /** Applies a dark color scheme to the user interface in the custom tab. Colors set through EXTRA_TOOLBAR_COLOR may be darkened to match user expectations. **/
    Dark;
}