package com.ianbrandt.buildlogic.artifacts.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.slf4j.LoggerFactory

/**
 * A lazy [DependencyHandler] extension that logs a stacktrace when the
 * [Dependency] is realized.
 */
class StackLoggingLazyDependencyCreationExtension(
    private val projectPath: String,
    private val providers: ProviderFactory,
) : LazyDependencyCreationExtension {

    private val logger =
        LoggerFactory.getLogger(StackLoggingLazyDependencyCreationExtension::class.java)

    override fun invoke(dependency: Dependency): Provider<Dependency> =
        providers.provider {

            // Debug logging.
            try {
                throw RuntimeException("Dependency creation stacktrace")
            } catch (e: RuntimeException) {
                logger.warn(
                    "Creating dependency $dependency for $projectPath...",
                    e
                )
            }

            dependency
        }
}
