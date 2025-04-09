package com.ianbrandt.buildlogic.artifacts.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.attributes.AttributeContainer
import org.slf4j.LoggerFactory

/**
 * An eager [DependencyHandler] extension that sets the attributes for variants
 * of a declared [Dependency].
 */
class EagerAttributesDependencyCreationExtension(
    private val projectPath: String,
    private val dependencyHandler: DependencyHandler,
    private val attributesConfigureAction: AttributeContainer.() -> Unit,
) : EagerDependencyCreationExtension {

    private val logger =
        LoggerFactory.getLogger(EagerAttributesDependencyCreationExtension::class.java)


    override fun invoke(notation: Any): Dependency {

        // Debug logging.
        try {
            throw RuntimeException()
        } catch (e: RuntimeException) {
            logger.warn("Creating dependency $notation for $projectPath...", e)
        }

        val dependency = dependencyHandler.create(notation)

        require(dependency is ModuleDependency)
        {
            "Dependency type '${dependency::class.qualifiedName}' unknown!"
        }

        dependency.attributes {
            attributesConfigureAction()
        }

        return dependency
    }
}
