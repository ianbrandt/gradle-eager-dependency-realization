dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

include(":subprojects:java-control")
include(":subprojects:java-eager")
include(":subprojects:java-lazy")
include(":subprojects:kotlin-control")
include(":subprojects:kotlin-eager")
include(":subprojects:kotlin-lazy")
include(":subprojects:util")

rootProject.name = "gradle-eager-dependency-realization"
