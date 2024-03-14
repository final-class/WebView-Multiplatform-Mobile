package com.final_class.webview_multiplatform_mobile.library.settings.android.activity_height

enum class HeightResizeBehavior {
    /** Applies the default height resize behavior for the Custom Tab Activity when it behaves as a bottom sheet. **/
    ACTIVITY_HEIGHT_DEFAULT,

    /** The Custom Tab Activity, when it behaves as a bottom sheet, can have its height manually resized by the user. **/
    ACTIVITY_HEIGHT_ADJUSTABLE,

    /** The Custom Tab Activity, when it behaves as a bottom sheet, cannot have its height manually resized by the user. **/
    ACTIVITY_HEIGHT_FIXED;
}