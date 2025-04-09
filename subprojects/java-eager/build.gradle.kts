plugins {
    id("java-library")
    id("com.ianbrandt.buildlogic.plugins.dependency-helper-plugin")
}

dependencies {
    implementation(eagerDependencyHelper(project(":subprojects:util")))
}
