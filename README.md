# WebView Multiplatform Mobile

**WebViewX** - это мультиплатформенная библиотека, которая обеспечивает простой и удобный способ встраивания веб-содержимого в ваши приложения для Android и iOS. Основанная на [CustomTabs](https://developer.android.com/reference/kotlin/androidx/browser/customtabs/package-summary) в Android и [SFSafariViewController](https://developer.apple.com/documentation/safariservices/sfsafariviewcontroller) в iOS, WebViewX обеспечивает безопасное и быстрое взаимодействие с веб-содержимым, сохраняя при этом нативный пользовательский интерфейс и производительность.

[Пример того, как выглядит WebView](https://github.com/final-class/WebView-Multiplatform-Mobile?tab=readme-ov-file#example)

### Особенности:
- **Мультиплатформенная совместимость:** Поддержка Android и iOS для обеспечения единого опыта встраивания веб-содержимого.
- **Интеграция с CustomTabs (Android) и SFSafariViewController (iOS):** Используйте стандартные компоненты каждой платформы для оптимальной производительности и безопасности.
- **Простота использования:** Интуитивный интерфейс API делает встраивание веб-содержимого легким и эффективным для разработчиков, а настройки для каждой платформы вдохновлены философией Compose Modifier из Jetpack Compose.

------------

### Подключение
1) Добавьте зависимость в commonMain вашего build.gradle
```
implementation("io.github.final-class:webview-multiplatform-mobile:1.0.1")
```
2) Используйте WebView в своем общем коде
```
WebViewPlatform(url = "https://github.com/")
```

------------

### Настройки
WebViewX предоставляет ряд настраиваемых параметров для оптимизации поведения и внешнего вида ваших встроенных веб-компонентов, которые вдохновлены философией Compose Modifier в Jetpack Compose. Каждая настройка WebViewX похожа на применение Modifier к встроенному веб-компоненту, что делает их использование элегантным и удобным.

#### Настройки для Android устанавливаются следующим образом:
```
WebViewPlatform(
    url = "https://github.com/",
    androidSettings = AndroidWebViewModifier
        .showTitle(true)
        .urlBarHidingEnabled(true)
        ...
)
```
**Описание имеющихся настроек для AndroidWebViewModifier**
                    
Method  | Description
------------- | -------------
showTitle  | Sets whether the title should be shown in the custom tab.
urlBarHidingEnabled  | Set whether the url bar should hide as the user scrolls down on the page.
shareState  | Sets the share state that should be applied to the custom tab.
instantAppsEnabled  | Sets whether Instant Apps is enabled for this Custom Tab.
toolbarCornerRadiusDp  | Sets the toolbar's top corner radii in dp.
activityHeight  | Sets the Custom Tab Activity's initial height in pixels and the desired resize behavior.
closeButtonPosition  | Sets the position of the close button.
startAnimations  | Sets the start animations.
exitAnimations  | Sets the exit animations.
scheme  | Sets the color scheme that should be applied to the user interface in the custom tab.
defaultColorSchemeParams  | Sets the default CustomTabColorSchemeParams. This will set a default color scheme that applies when no AndroidScheme specified for current color scheme via scheme.
darkColorSchemeParams  | Sets the dark CustomTabColorSchemeParams. This will set a dark color scheme that applies when AndroidScheme.Dark specified for current color scheme via scheme.


#### Настройки для iOS устанавливаются следующим образом:
```
WebViewPlatform(
    url = "https://github.com/",
    iosSettings = IosWebViewModifier
        .barCollapsingEnabled(true)
        .entersReaderIfAvailable(true)
        ...
)
```

**Описание имеющихся настроек для IosWebViewModifier**
                    
Method  | Description
------------- | -------------
barCollapsingEnabled  | enabled bar collapsing.
entersReaderIfAvailable  | a value that specifies whether Safari should enter Reader mode, if it is available.
dismissButtonStyle  | sets dismiss button style.
preferredBarTintColor  | the color to tint the background of the navigation bar and the toolbar.
preferredControlTintColor  | the color to tint the control buttons on the navigation bar and the toolbar.

------------

### Example

[![Typing SVG](https://readme-typing-svg.demolab.com/?lines=First+line+of+text;Second+line+of+text)](https://git.io/typing-svg)

![](https://imgur.com/VzCepMA.png) ![](https://imgur.com/YzVZ5sU.png)

------------

### Вклад
🚀 Мы приветствуем ваши вклады! Если у вас есть предложения по улучшению или обнаружили проблемы, пожалуйста, создайте Issue или Pull Request на нашем GitHub репозитории.
