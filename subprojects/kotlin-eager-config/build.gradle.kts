plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":subprojects:util")) {
        // Debug logging.
        logger.lifecycle(
            "Configuring dependency $this for ${project.path}...",
            RuntimeException("Dependency config stacktrace")
        )
    }
}
