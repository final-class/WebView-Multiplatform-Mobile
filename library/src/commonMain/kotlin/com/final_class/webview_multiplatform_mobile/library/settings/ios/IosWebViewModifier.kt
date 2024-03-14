package com.final_class.webview_multiplatform_mobile.library.settings.ios


interface IosWebViewModifier {

    fun provide(): IosSettings

    companion object : IosWebViewModifier {
        override fun provide(): IosSettings = IosSettings()
    }
}
