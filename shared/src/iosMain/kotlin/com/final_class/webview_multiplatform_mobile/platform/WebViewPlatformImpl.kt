package com.final_class.webview_multiplatform_mobile.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import com.final_class.webview_multiplatform_mobile.library.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.library.settings.ios.IosSettings
import com.final_class.webview_multiplatform_mobile.library.settings.ios.dismiss_button_style.DismissButtonStyle
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSURL
import platform.SafariServices.SFSafariViewController
import platform.SafariServices.SFSafariViewControllerConfiguration
import platform.SafariServices.SFSafariViewControllerDismissButtonStyle
import platform.UIKit.UIApplication
import platform.UIKit.UIColor

/**
 * Created by Dmitry Aleksandrovich on 25.02.2024
 **/
@OptIn(ExperimentalForeignApi::class)
@Composable
internal actual fun WebViewPlatformImpl(
    modifier: Modifier,
    url: String,
    androidSettings: AndroidSettings,
    iosSettings: IosSettings,
    onClose: (() -> Unit)?
) {
    // Преобразование url в NSURL
    val nsurl = remember { NSURL(string = url) }

    // Конфигурация для SFSafariViewController
    val configuration = remember { SFSafariViewControllerConfiguration() }

    iosSettings.barCollapsingEnabled?.let { configuration.setBarCollapsingEnabled(it) }
    iosSettings.entersReaderIfAvailable?.let { configuration.setEntersReaderIfAvailable(it) }

    // Safari контроллер (это и есть бразуер Сафари внутри приложения)
    val safariController = remember { SFSafariViewController(uRL = nsurl, configuration = configuration) }

    iosSettings.dismissButtonStyle?.let { safariController.setDismissButtonStyle(it) }
    iosSettings.preferredBarTintColor?.let { safariController.setPreferredBarTintColor(it.toUIColor()) }
    iosSettings.preferredControlTintColor?.let { safariController.setPreferredControlTintColor(it.toUIColor()) }

    val viewController = remember { UIApplication.sharedApplication.keyWindow?.rootViewController }

    UIKitView(
        modifier = modifier,
        factory = {
            viewController?.presentViewController(safariController, animated = true, completion = null)

            // Загружаем View
            viewController?.loadView()

            // Возвращаем View
            safariController.view()
        },
        onRelease = {
            onClose?.invoke()
        }
    )
}

private fun SFSafariViewController.setDismissButtonStyle(dismissButtonStyle: DismissButtonStyle) {
    val buttonStyle = when (dismissButtonStyle) {
        DismissButtonStyle.Close -> SFSafariViewControllerDismissButtonStyle.SFSafariViewControllerDismissButtonStyleClose
        DismissButtonStyle.Cancel -> SFSafariViewControllerDismissButtonStyle.SFSafariViewControllerDismissButtonStyleCancel
        DismissButtonStyle.Done -> SFSafariViewControllerDismissButtonStyle.SFSafariViewControllerDismissButtonStyleDone
    }

    this.dismissButtonStyle = buttonStyle
}

private fun Color.toUIColor(): UIColor = UIColor(
    red = this.red.toDouble(),
    green = this.green.toDouble(),
    blue = this.blue.toDouble(),
    alpha = this.alpha.toDouble()
)