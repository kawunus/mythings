// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    kotlin("kapt") version "2.0.20"
    id("androidx.navigation.safeargs") version "2.8.1" apply false
}