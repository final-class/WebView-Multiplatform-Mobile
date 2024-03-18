# WebView Multiplatform Mobile

**WebViewX** - это мультиплатформенная библиотека, которая обеспечивает простой и удобный способ встраивания веб-содержимого в ваши приложения для Android и iOS. Основанная на [CustomTabs](https://developer.android.com/reference/kotlin/androidx/browser/customtabs/package-summary) в Android и [SFSafariViewController](https://developer.apple.com/documentation/safariservices/sfsafariviewcontroller) в iOS, WebViewX обеспечивает безопасное и быстрое взаимодействие с веб-содержимым, сохраняя при этом нативный пользовательский интерфейс и производительность.

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
)
```

------------

### Вклад
Мы приветствуем ваши вклады! Если у вас есть предложения по улучшению или обнаружили проблемы, пожалуйста, создайте Issue или Pull Request на нашем GitHub репозитории.

[![Typing SVG](https://readme-typing-svg.demolab.com/?lines=First+line+of+text;Second+line+of+text)](https://git.io/typing-svg)

![](https://imgur.com/VzCepMA.png) ![](https://imgur.com/YzVZ5sU.png)
