package com.ianbrandt.buildlogic.artifacts.dsl

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.attributes.AttributeContainer
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.slf4j.LoggerFactory

/**
 * A lazy [DependencyHandler] extension that sets the attributes for variants
 * of a declared [Dependency].
 */
class LazyAttributesDependencyCreationExtension(
    private val projectPath: String,
    private val dependencyHandler: DependencyHandler,
    private val providers: ProviderFactory,
    private val attributesConfigureAction: AttributeContainer.() -> Unit,
) : LazyDependencyCreationExtension {

    private val logger =
        LoggerFactory.getLogger(LazyAttributesDependencyCreationExtension::class.java)

    override fun invoke(notation: Any): Provider<Dependency> =
        providers.provider {

            // Debug logging.
            try {
                throw RuntimeException()
            } catch (e: RuntimeException) {
                logger.warn(
                    "Creating dependency $notation for $projectPath...",
                    e,
                )
            }

            val dependency = dependencyHandler.create(notation)

            require(dependency is ModuleDependency)
            {
                "Dependency type '${dependency::class.qualifiedName}' unknown!"
            }

            dependency.attributes {
                attributesConfigureAction()
            }

            dependency
        }
}
