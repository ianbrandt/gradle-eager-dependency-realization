plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":subprojects:util")) {
        // Debug logging.
        try {
            throw RuntimeException()
        } catch (e: RuntimeException) {
            logger.lifecycle(
                "Configuring dependency $this for ${project.path}...", e
            )
        }
    }
}
