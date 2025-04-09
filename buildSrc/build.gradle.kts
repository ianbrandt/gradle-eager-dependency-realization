plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.kotlin.gradle.plugin.dependency)
}

gradlePlugin {
    plugins {
        create("dependency-helper-plugin") {
            id = "com.ianbrandt.buildlogic.plugins.dependency-helper-plugin"
            implementationClass =
                "com.ianbrandt.buildlogic.plugins.DependencyHelperPlugin"
        }
    }
}
