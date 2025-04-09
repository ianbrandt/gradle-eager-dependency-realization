dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

include(":subprojects:java-eager")
include(":subprojects:java-eager-config")
include(":subprojects:java-lazy")
include(":subprojects:java-lazy-config")
include(":subprojects:kotlin-eager")
include(":subprojects:kotlin-eager-config")
include(":subprojects:kotlin-lazy")
include(":subprojects:kotlin-lazy-config")
include(":subprojects:util")

rootProject.name = "gradle-eager-dependency-realization"
