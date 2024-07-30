plugins {
    kotlin("multiplatform") version "1.8.22"
    kotlin("plugin.serialization") version "1.8.22"
}

repositories {
    mavenCentral()
}

group = "me.fortibrine"
version = "1.0"

kotlin {
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                // React
                implementation(enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.430"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

                //Kotlin React Emotion (CSS) (chapter 3)
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

                // Bootstrap
                implementation(npm("react-bootstrap", "2.10.4"))
                implementation(npm("bootstrap", "5.0.0"))
            }
        }
    }
}