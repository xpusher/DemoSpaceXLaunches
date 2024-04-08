import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnLockMismatchReport
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
}
sqldelight {
    databases {
        create("Player") {
            packageName.set("com.example.project")
            generateAsync.set(true)
        }

    }
}

kotlin {
    js {
        browser {
//            commonWebpackConfig {
//                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
//                    static = (static ?: mutableListOf()).apply {
//                        // Serve sources to debug inside browser
//                        add(project.projectDir.path)
//                    }
//                }
//            }


        }
        binaries.executable()
    }
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    jvm()

    rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin::class.java) {
        rootProject.the<YarnRootExtension>().yarnLockMismatchReport =
            YarnLockMismatchReport.WARNING // NONE | FAIL
        rootProject.the<YarnRootExtension>().reportNewYarnLock = false // true
        rootProject.the<YarnRootExtension>().yarnLockAutoReplace = false // true
    }
    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation(libs.sqldelight.runtime)
            implementation(libs.kotlinx.coroutines.core)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android)
        }
        nativeMain.dependencies {
            implementation(libs.sqldelight.native)
        }
        jsMain.dependencies {
            implementation(libs.sqldelight.web)
            //npm install copy-webpack-plugin --save-dev
            implementation(npm("@cashapp/sqldelight-sqljs-worker", "2.0.1"))
            implementation(npm("sql.js", "1.8.0"))
//            implementation("app.cash.sqldelight:web-worker-driver:2.0.0")
//            implementation(devNpm("copy-webpack-plugin", "9.1.0"))
        }
        jvmMain.dependencies {
            implementation(libs.sqldelight.sqlite)
        }

    }
}

android {
    namespace = "org.example.project.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
