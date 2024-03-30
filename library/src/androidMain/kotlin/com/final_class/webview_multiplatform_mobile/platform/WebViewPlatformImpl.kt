package com.final_class.webview_multiplatform_mobile.platform

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsIntent.ACTIVITY_HEIGHT_ADJUSTABLE
import androidx.browser.customtabs.CustomTabsIntent.ACTIVITY_HEIGHT_DEFAULT
import androidx.browser.customtabs.CustomTabsIntent.ACTIVITY_HEIGHT_FIXED
import androidx.browser.customtabs.CustomTabsIntent.CLOSE_BUTTON_POSITION_DEFAULT
import androidx.browser.customtabs.CustomTabsIntent.CLOSE_BUTTON_POSITION_END
import androidx.browser.customtabs.CustomTabsIntent.CLOSE_BUTTON_POSITION_START
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.final_class.webview_multiplatform_mobile.webview.settings.android.AndroidSettings
import com.final_class.webview_multiplatform_mobile.webview.settings.android.activity_height.ActivityHeight
import com.final_class.webview_multiplatform_mobile.webview.settings.android.activity_height.HeightResizeBehavior
import com.final_class.webview_multiplatform_mobile.webview.settings.android.android_scheme_colors.ColorSchemeParams
import com.final_class.webview_multiplatform_mobile.webview.settings.android.close_button_position.CloseButtonPosition
import com.final_class.webview_multiplatform_mobile.webview.settings.android.scheme.AndroidScheme
import com.final_class.webview_multiplatform_mobile.webview.settings.android.share.ShareState
import com.final_class.webview_multiplatform_mobile.webview.settings.ios.IosSettings

@Composable
internal actual fun WebViewPlatformImpl(
    url: String,
    openInExternalBrowser: Boolean,
    androidSettings: AndroidSettings,
    iosSettings: IosSettings,
) {
    val context = LocalContext.current

    val customTabsIntent = createCustomTabs(
        context = context,
        androidSettings = androidSettings,
        openInExternalBrowser = openInExternalBrowser
    )

    customTabsIntent.launchUrl(context, Uri.parse(url))
}

private fun createCustomTabs(context: Context, androidSettings: AndroidSettings, openInExternalBrowser: Boolean): CustomTabsIntent {
    val customTabsBuilder = CustomTabsIntent.Builder()

    androidSettings.showTitle?.let { customTabsBuilder.setShowTitle(it) }
    androidSettings.urlBarHidingEnabled?.let { customTabsBuilder.setUrlBarHidingEnabled(it) }
    androidSettings.shareState?.let { customTabsBuilder.setShareState(it) }
    androidSettings.instantAppsEnabled?.let { customTabsBuilder.setInstantAppsEnabled(it) }
    androidSettings.toolbarCornerRadiusDp?.let { customTabsBuilder.setToolbarCornerRadiusDp(it) }
    androidSettings.activityHeight?.let { customTabsBuilder.setInitialActivityHeightPx(it) }
    androidSettings.closeButtonPosition?.let { customTabsBuilder.setCloseButtonIcon(it) }
    androidSettings.startAnimation?.let { customTabsBuilder.setStartAnimations(context, it.enterResId, it.exitResId) }
    androidSettings.exitAnimation?.let { customTabsBuilder.setExitAnimations(context, it.enterResId, it.exitResId) }
    androidSettings.scheme?.let { customTabsBuilder.setColorScheme(scheme = it) }
    androidSettings.defaultColorSchemeParams?.let { customTabsBuilder.setDefaultColorSchemeParams(it) }
    androidSettings.darkColorSchemeParams?.let { customTabsBuilder.setDarkColorSchemeParams(it) }

    return customTabsBuilder.build().apply {
        if (openInExternalBrowser) intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
}

private fun CustomTabsIntent.Builder.setShareState(shareState: ShareState) {
    when (shareState) {
        ShareState.SHARE_STATE_DEFAULT -> this.setShareState(CustomTabsIntent.SHARE_STATE_DEFAULT)
        ShareState.SHARE_STATE_ON -> this.setShareState(CustomTabsIntent.SHARE_STATE_ON)
        ShareState.SHARE_STATE_OFF -> this.setShareState(CustomTabsIntent.SHARE_STATE_OFF)
    }
}

private fun CustomTabsIntent.Builder.setInitialActivityHeightPx(activityHeight: ActivityHeight) {
    val heightResizeBehavior = when (activityHeight.heightResizeBehavior) {
        HeightResizeBehavior.ACTIVITY_HEIGHT_DEFAULT -> ACTIVITY_HEIGHT_DEFAULT
        HeightResizeBehavior.ACTIVITY_HEIGHT_ADJUSTABLE -> ACTIVITY_HEIGHT_ADJUSTABLE
        HeightResizeBehavior.ACTIVITY_HEIGHT_FIXED -> ACTIVITY_HEIGHT_FIXED
        else -> null
    }

    if (heightResizeBehavior == null) {
        this.setInitialActivityHeightPx(activityHeight.initialHeightPx)
    } else {
        this.setInitialActivityHeightPx(activityHeight.initialHeightPx, heightResizeBehavior)
    }
}

private fun CustomTabsIntent.Builder.setCloseButtonIcon(closeButtonPosition: CloseButtonPosition) {
    val closeButtonPosition = when (closeButtonPosition) {
        CloseButtonPosition.DEFAULT -> CLOSE_BUTTON_POSITION_DEFAULT
        CloseButtonPosition.START -> CLOSE_BUTTON_POSITION_START
        CloseButtonPosition.END -> CLOSE_BUTTON_POSITION_END
    }

    this.setCloseButtonPosition(closeButtonPosition)
}

private fun CustomTabsIntent.Builder.setColorScheme(scheme: AndroidScheme) {
    when (scheme) {
        AndroidScheme.System -> this.setColorScheme(CustomTabsIntent.COLOR_SCHEME_SYSTEM)
        AndroidScheme.Light -> this.setColorScheme(CustomTabsIntent.COLOR_SCHEME_LIGHT)
        AndroidScheme.Dark -> this.setColorScheme(CustomTabsIntent.COLOR_SCHEME_DARK)
    }
}

private fun CustomTabsIntent.Builder.setDefaultColorSchemeParams(colorSchemeParams: ColorSchemeParams) {
    val customTabColorSchemeParams = CustomTabColorSchemeParams.Builder()

    colorSchemeParams.toolbarColor?.let { customTabColorSchemeParams.setToolbarColor(it.toArgb()) }
    colorSchemeParams.secondaryToolbarColor?.let { customTabColorSchemeParams.setSecondaryToolbarColor(it.toArgb()) }
    colorSchemeParams.navigationBarColor?.let { customTabColorSchemeParams.setNavigationBarColor(it.toArgb()) }
    colorSchemeParams.navigationBarDividerColor?.let { customTabColorSchemeParams.setNavigationBarDividerColor(it.toArgb()) }

    this.setDefaultColorSchemeParams(customTabColorSchemeParams.build())
}

private fun CustomTabsIntent.Builder.setDarkColorSchemeParams(colorSchemeParams: ColorSchemeParams) {
    val customTabColorSchemeParams = CustomTabColorSchemeParams.Builder()

    colorSchemeParams.toolbarColor?.let { customTabColorSchemeParams.setToolbarColor(it.toArgb()) }
    colorSchemeParams.secondaryToolbarColor?.let { customTabColorSchemeParams.setSecondaryToolbarColor(it.toArgb()) }
    colorSchemeParams.navigationBarColor?.let { customTabColorSchemeParams.setNavigationBarColor(it.toArgb()) }
    colorSchemeParams.navigationBarDividerColor?.let { customTabColorSchemeParams.setNavigationBarDividerColor(it.toArgb()) }

    this.setColorSchemeParams(CustomTabsIntent.COLOR_SCHEME_DARK, customTabColorSchemeParams.build())
}