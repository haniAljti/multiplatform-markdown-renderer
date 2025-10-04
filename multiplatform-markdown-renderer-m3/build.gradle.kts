plugins {
    id("com.mikepenz.convention.android-library")
    id("com.mikepenz.convention.kotlin-multiplatform")
    id("com.mikepenz.convention.compose")
    id("com.mikepenz.convention.publishing")
}

android {
    namespace = "com.mikepenz.markdown.m3"

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
    commonMainApi(libs.markdown)

    commonMainCompileOnly(compose.runtime)
    commonMainCompileOnly(compose.material3)
}