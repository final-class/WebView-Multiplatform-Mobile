package com.final_class.webview_multiplatform_mobile.library.settings.ios


/**
 * Created by Dmitry Aleksandrovich on 29.02.2024
 **/
interface IosWebViewModifier {

    infix fun then(their: IosWebViewModifier): IosSettings =
        if (their is IosSettings) this as IosSettings else IosSettings()

    fun provide(): IosSettings

    companion object : IosWebViewModifier {
        override fun provide(): IosSettings = IosSettings()
    }
}
