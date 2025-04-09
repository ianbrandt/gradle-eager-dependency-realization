package com.ianbrandt.buildlogic.plugins

import com.ianbrandt.buildlogic.artifacts.dsl.EagerAttributesDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.EagerDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.LazyAttributesDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.LazyDependencyCreationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.attributes.Attribute

@Suppress("unused")
class DependencyHelperPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.dependencies.extensions.add(
            EagerDependencyCreationExtension::class.java,
            "eagerDependencyHelper",
            EagerAttributesDependencyCreationExtension(
                projectPath = project.path,
                dependencyHandler = project.dependencies,
                attributesConfigureAction = {
                    attribute(
                        Attribute.of("Testing", String::class.java),
                        "eager"
                    )
                }
            )
        )

        project.dependencies.extensions.add(
            LazyDependencyCreationExtension::class.java,
            "lazyDependencyHelper",
            LazyAttributesDependencyCreationExtension(
                projectPath = project.path,
                dependencyHandler = project.dependencies,
                providers = project.providers,
                attributesConfigureAction = {
                    attribute(
                        Attribute.of("Testing", String::class.java),
                        "lazy"
                    )
                }
            )
        )
    }
}
