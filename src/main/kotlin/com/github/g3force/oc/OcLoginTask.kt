package com.github.g3force.oc

import org.gradle.api.tasks.TaskAction


abstract class OcLoginTask : OcExec() {

    @TaskAction
    override fun doAction() {
        val config = project.extensions.getByType(OcPluginExtension::class.java)
        val tokenFile = config.tokenFile
        if (tokenFile != null && tokenFile.exists()) {
            config.token = tokenFile.readText()
        }

        args = listOf("login", config.clusterUrl, "--token", config.token)
        super.doAction()
    }
}