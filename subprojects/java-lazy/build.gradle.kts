plugins {
    id("java-library")
    id("com.ianbrandt.buildlogic.plugins.dependency-helper-plugin")
}

dependencies {
    implementation(lazyDependencyHelper(project(":subprojects:util")))
}
