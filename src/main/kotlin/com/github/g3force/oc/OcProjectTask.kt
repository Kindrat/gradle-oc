package com.github.g3force.oc

import org.gradle.api.tasks.TaskAction

abstract class OcProjectTask : OcExecTask() {

    @TaskAction
    override fun doAction() {
        val config = project.extensions.getByType(OcPluginExtension::class.java)
        execute(listOf("project", config.projectName, "--server", config.clusterUrl))
    }
}