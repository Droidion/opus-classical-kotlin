package net.opusclassical.views

import io.ktor.server.html.*
import kotlinx.css.*
import kotlinx.html.*
import net.opusclassical.views.partials.FooterTemplate

class LayoutTemplate: Template<HTML> {
    private val footer = TemplatePlaceholder<FooterTemplate>()
    val content = Placeholder<FlowContent>()
    override fun HTML.apply() {
        head {
            title { +"Test" }
            link(rel = "stylesheet", href = "/styles.css", type = "text/css")
            link(rel = "stylesheet", href = "/static/styles.css", type = "text/css")

        }
        body {
            insert(content)
            insert(FooterTemplate(), footer)
        }
    }
}
