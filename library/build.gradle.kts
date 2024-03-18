import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.maven.publish)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            /** Compose **/
            implementation(compose.foundation)
        }

        androidMain.dependencies {
            /** Compose **/
            implementation(libs.androidx.activity.compose)

            /** CustomTabs **/
            implementation(libs.androidx.customTabs)
        }
    }
}

android {
    namespace = "com.final_class.webview_multiplatform_mobile"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
}

mavenPublishing {
    val version = "1.0.1"
    val groupId = "io.github.final-class"
    val artifact = "webview-multiplatform-mobile"

    coordinates(groupId, artifact, version)

    pom {
        name.set("WebView-Multiplatform-Mobile")
        description.set("WebView library for Kotlin Mobile Multiplatform (Android/iOS)")
        url.set("https://github.com/final-class/WebView-Multiplatform-Mobile")

        licenses {
            license {
                name.set("Library Licence")
                url.set("https://github.com/final-class/WebView-Multiplatform-Mobile/blob/main/LICENSE")
            }
        }

        developers {
            developer {
                id.set("final-class")
                name.set("Dmitry Aleksandrovich")
                url.set("https://github.com/final-class")
            }
        }

        scm {
            connection.set("scm:git:github.com/final-class/WebView-Multiplatform-Mobile.git")
            developerConnection.set("scm:git:ssh://github.com/final-class/WebView-Multiplatform-Mobile.git")
            url.set("https://github.com/final-class/WebView-Multiplatform-Mobile/tree/main")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}