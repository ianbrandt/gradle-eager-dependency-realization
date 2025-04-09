package com.ianbrandt.buildlogic.artifacts.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * An invokable interface for [DependencyHandler] extensions that eagerly
 * create dependencies. Facilitates calling the extensions as unqualified
 * helper functions.
 */
fun interface EagerDependencyCreationExtension {
    operator fun invoke(dependency: Dependency): Dependency
}
