package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.*

class LogoTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        a("/") {
            classes = setOf("hover:no-underline")
            div {
                classes = setOf("flex", "items-center")
                svg {
                    classes = setOf("logo", "icon", "h-9", "w-9", "xl:h-16", "xl:w-16")
                    attributes["width"] = "72"
                    attributes["height"] = "72"
                    unsafe {
                        +"""<use href="/static/images/sprites.svg#opusclassical">"""
                    }
                }
                div {
                    classes = setOf("ml-2", "xl:ml-4")
                    div {
                        classes = setOf("font-serif", "text-lg", "font-medium", "xl:text-3xl")
                        +"Opus Classical"
                    }
                    div {
                        classes = setOf("text-xs", "xl:text-base")
                        +"Catalogue for streaming classical music"
                    }
                }
            }
        }
    }
}