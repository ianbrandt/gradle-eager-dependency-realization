plugins {
    kotlin("jvm")
    id("com.ianbrandt.buildlogic.plugins.dependency-helper-plugin")
}

dependencies {
    implementation(lazyDependency(project(":subprojects:util")))
}
