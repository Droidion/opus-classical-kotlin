package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.FlowContent
import kotlinx.html.header
import kotlinx.html.a
import kotlinx.html.img

class HeaderTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
            +"ssss"
        }
    }
}
