package com.ianbrandt.buildlogic.plugins

import com.ianbrandt.buildlogic.artifacts.dsl.EagerDependencyCreationExtension
import com.ianbrandt.buildlogic.artifacts.dsl.StackLoggingEagerDependencyCreationExtension
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
    }
}
