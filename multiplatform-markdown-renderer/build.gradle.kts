plugins {
    id("com.mikepenz.convention.android-library")
    id("com.mikepenz.convention.kotlin-multiplatform")
    id("com.mikepenz.convention.compose")
    id("com.mikepenz.convention.publishing")
}

android {
    namespace = "com.mikepenz.markdown"

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

composeCompiler {
    stabilityConfigurationFiles.add(project.layout.projectDirectory.file("stability_config.conf"))
}

dependencies {
    commonMainApi(libs.markdown)
    commonMainApi(baseLibs.kotlinx.collections.immutable)

    commonMainCompileOnly(compose.runtime)
    commonMainCompileOnly(compose.ui)
    commonMainCompileOnly(compose.foundation)
}