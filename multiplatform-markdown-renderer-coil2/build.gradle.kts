plugins {
    id("com.mikepenz.convention.android-library")
    id("com.mikepenz.convention.kotlin-multiplatform")
    id("com.mikepenz.convention.compose")
    id("com.mikepenz.convention.publishing")
}

android {
    namespace = "com.mikepenz.markdown.coil2"

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "io.jitpack"
            artifactId = "library"
            version = "1.0"
            from(components["release"])
        }
    }
}

dependencies {
    commonMainApi(projects.multiplatformMarkdownRenderer)
    commonMainCompileOnly(compose.runtime)
    commonMainCompileOnly(compose.ui)

    androidMainApi(libs.coil2.core)
}
