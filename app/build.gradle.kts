import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.synth.couplehub"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.synth.couplehub"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        val clientKeyApi = project.rootProject.file("local.properties")
            .readLines()
            .first { it.startsWith("CLIENT_KEY_API") }
            .split("=")[1]

        buildConfigField("String", "CLIENT_KEY_API", "\"$clientKeyApi\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes(action =  {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt") , "proguard-rules.pro")
            }
        }
    )
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        buildConfig = true
    }

}


dependencies {
// Splash Screen
    implementation (libs.androidx.appcompat)

//    Data Store
    implementation (libs.androidx.datastore.preferences.v100)

    implementation("io.coil-kt.coil3:coil-compose:3.0.4")

    implementation(libs.onetapcompose)

    implementation(libs.material)
    implementation(libs.firebase.vertexai)
//    ViewModel
    val lifecycle_version = "2.8.7"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
//  Data Store
    implementation(libs.datastore.preferences)


//    Navigation
    implementation(libs.androidx.navigation.compose)

    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.text.google.fonts)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
