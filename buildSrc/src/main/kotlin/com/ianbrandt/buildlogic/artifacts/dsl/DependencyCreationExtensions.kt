package com.ianbrandt.buildlogic.artifacts.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider

/**
 * An invokable interface for [DependencyHandler] extensions that eagerly
 * create dependencies. Facilitates calling the extensions as unqualified
 * helper functions.
 */
fun interface EagerDependencyCreationExtension {
    operator fun invoke(notation: Any): Dependency
}

/**
 * An invokable interface for [DependencyHandler] extensions that lazily
 * create dependencies. Facilitates calling the extensions as unqualified
 * helper functions.
 */
fun interface LazyDependencyCreationExtension {
    operator fun invoke(notation: Any): Provider<Dependency>
}
