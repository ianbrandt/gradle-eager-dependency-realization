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
        logger.warn(
            "Creating dependency $dependency for $projectPath...",
            RuntimeException("Dependency creation stacktrace")
        )

        return dependency
    }
}
