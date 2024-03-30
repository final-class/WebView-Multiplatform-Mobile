package com.final_class.webview_multiplatform_mobile.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.final_class.webview_multiplatform_mobile.webview.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.IosSettings
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.dismiss_button_style.DismissButtonStyle
import platform.Foundation.NSURL
import platform.SafariServices.SFSafariViewController
import platform.SafariServices.SFSafariViewControllerConfiguration
import platform.SafariServices.SFSafariViewControllerDismissButtonStyle
import platform.UIKit.UIApplication
import platform.UIKit.UIColor

@Composable
internal actual fun WebViewPlatformImpl(
    url: String,
    openInExternalBrowser: Boolean,
    androidSettings: AndroidSettings,
    iosSettings: IosSettings,
) {
    val nsurl = NSURL(string = url)
    val safariConfiguration = createSafariConfiguration(iosSettings = iosSettings)
    val safariViewController = createSafariViewController(
        url = nsurl,
        configuration = safariConfiguration,
        iosSettings = iosSettings
    )

    if (openInExternalBrowser) {
        UIApplication.sharedApplication.openURL(url = nsurl)
    } else {
        val viewController = UIApplication.sharedApplication.keyWindow?.rootViewController
        viewController?.presentViewController(safariViewController, animated = true, completion = null)
    }
}

private fun createSafariViewController(
    url: NSURL,
    configuration: SFSafariViewControllerConfiguration,
    iosSettings: IosSettings
): SFSafariViewController {
    return SFSafariViewController(uRL = url, configuration = configuration).apply {
        iosSettings.dismissButtonStyle?.let { setDismissButtonStyle(it) }
        iosSettings.preferredBarTintColor?.let { setPreferredBarTintColor(it.toUIColor()) }
        iosSettings.preferredControlTintColor?.let { setPreferredControlTintColor(it.toUIColor()) }
    }
}

private fun createSafariConfiguration(iosSettings: IosSettings): SFSafariViewControllerConfiguration {
    return SFSafariViewControllerConfiguration().apply {
        iosSettings.barCollapsingEnabled?.let { setBarCollapsingEnabled(it) }
        iosSettings.entersReaderIfAvailable?.let { setEntersReaderIfAvailable(it) }
    }
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