package com.final_class.webview_multiplatform_mobile.library.settings.android

/**
 * Created by Dmitry Aleksandrovich on 29.02.2024
 **/
interface AndroidWebViewModifier {

    infix fun then(their: AndroidWebViewModifier): AndroidSettings =
        if (their is AndroidSettings) this as AndroidSettings else AndroidSettings()

    fun provide(): AndroidSettings

    companion object : AndroidWebViewModifier {
        override fun provide(): AndroidSettings = AndroidSettings()
    }
}