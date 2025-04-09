plugins {
    id("java-library")
}

dependencies {
    implementation(provider {
        val notation = ":subprojects:util"
        // Debug logging.
        try {
            throw RuntimeException("Dependency creation stacktrace")
        } catch (e: RuntimeException) {
            logger.warn(
                "Creating dependency $notation for ${project.path}...", e
            )
        }
        project(notation)
    })
}
