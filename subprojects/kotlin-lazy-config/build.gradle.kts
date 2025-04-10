plugins {
    kotlin("jvm")
}

dependencies {
    implementation(provider {
        project(":subprojects:util") {
            // Debug logging.
            logger.lifecycle(
                "Configuring dependency $this for ${project.path}...",
                RuntimeException("Dependency config stacktrace")
            )
        }
    })
}
