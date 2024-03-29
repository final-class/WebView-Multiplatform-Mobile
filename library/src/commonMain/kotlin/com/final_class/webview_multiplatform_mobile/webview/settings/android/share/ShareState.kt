package com.final_class.webview_multiplatform_mobile.webview.settings.android.share

enum class ShareState {
    /** Applies the default share settings depending on the browser. **/
    SHARE_STATE_DEFAULT,

    /** Explicitly does not show a share option in the tab. **/
    SHARE_STATE_OFF,

    /** Shows a share option in the tab. **/
    SHARE_STATE_ON;
}