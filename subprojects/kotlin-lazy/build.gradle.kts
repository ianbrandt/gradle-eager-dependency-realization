plugins {
    kotlin("jvm")
}

dependencies {
    implementation(provider {
        val notation = ":subprojects:util"
        // Debug logging.
        logger.warn(
            "Creating dependency $notation for ${project.path}...",
            RuntimeException("Dependency creation stacktrace")
        )
        project(notation)
    })
}
