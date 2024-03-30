package com.final_class.webview_multiplatform_mobile.webview.settings.android

interface AndroidWebViewModifier {

    fun provide(): AndroidSettings

    /**
     * The companion object AndroidWebViewModifier is the empty, default, or starter AndroidWebViewModifier that contains no elements.
     * Use it to create a new AndroidWebViewModifier using modifier extension factory functions
     **/
    companion object : AndroidWebViewModifier {
        override fun provide(): AndroidSettings = AndroidSettings()
    }
}