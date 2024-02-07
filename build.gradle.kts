buildscript {
    repositories {
        maven {url = uri("https://developer.huawei.com/repo/")}
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0")
        classpath("com.google.gms:google-services:4.4.0")
        classpath("gradle.plugin.com.onesignal:onesignal-gradle-plugin:0.14.0")
        classpath("com.huawei.agconnect:agcp:1.9.1.300")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}