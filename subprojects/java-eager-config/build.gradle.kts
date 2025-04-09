plugins {
    id("java-library")
}

dependencies {
    implementation(project(":subprojects:util")) {
        // Debug logging.
        try {
            throw RuntimeException("Dependency config stacktrace")
        } catch (e: RuntimeException) {
            logger.lifecycle(
                "Configuring dependency $this for ${project.path}...", e
            )
        }
    }
}
