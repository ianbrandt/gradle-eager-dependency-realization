package com.ianbrandt.buildlogic.artifacts.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.slf4j.LoggerFactory

/**
 * An eager [DependencyHandler] extension that logs a stacktrace when the
 * [Dependency] is realized.
 */
class StackLoggingEagerDependencyCreationExtension(
    private val projectPath: String,
) : EagerDependencyCreationExtension {

    private val logger =
        LoggerFactory.getLogger(StackLoggingEagerDependencyCreationExtension::class.java)

    override fun invoke(dependency: Dependency): Dependency {

        // Debug logging.
        try {
            throw RuntimeException("Dependency creation stacktrace")
        } catch (e: RuntimeException) {
            logger.warn(
                "Creating dependency $dependency for $projectPath...",
                e
            )
        }

        return dependency
    }
}
