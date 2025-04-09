package com.ianbrandt.buildlogic.plugins

import com.ianbrandt.buildlogic.artifacts.dsl.EagerDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.LazyDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.StackLoggingEagerDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.StackLoggingLazyDependencyCreationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class DependencyHelperPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.dependencies.extensions.add(
            EagerDependencyCreationExtension::class.java,
            "eagerDependency",
            StackLoggingEagerDependencyCreationExtension(
                projectPath = project.path,
            )
        )

        project.dependencies.extensions.add(
            LazyDependencyCreationExtension::class.java,
            "lazyDependency",
            StackLoggingLazyDependencyCreationExtension(
                projectPath = project.path,
                providers = project.providers,
            )
        )
    }
}
