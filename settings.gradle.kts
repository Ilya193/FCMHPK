pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {url = uri("https://developer.huawei.com/repo/")}
    }

    resolutionStrategy {
        eachPlugin {
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {url = uri("https://developer.huawei.com/repo/")}
    }
}

rootProject.name = "PushOneSignal"
include(":app")
