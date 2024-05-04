package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.FlowContent
import kotlinx.html.*

class FooterTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        footer {
            classes = setOf("dark:xl:bg-codgray", "dark:bg-mineshaft", "flex", "h-16", "w-full", "max-w-screen-xl", "items-center", "justify-center", "bg-black/20", "px-4", "xl:bg-white")
            a("https://www.buymeacoffee.com/zunh") {
                classes = setOf("mx-3")
                title = "Buy me a coffee"
                img("Buy me a coffee", "/static/images/bmc-button.svg") {
                    classes = setOf("h-8")
                    width = "128"
                    height = "36"
                }
            }
            a("https://github.com/Droidion/opus-classical-kotlin") {
                classes = setOf("mx-3")
                title = "GitHub repository"
                svg {
                    classes = setOf("icon", "h-8", "w-12")
                    attributes["enable-background"] = "new 0 0 438.549 438.549"
                    attributes["height"] = "36"
                    attributes["width"] = "36"
                    unsafe {
                        +"""<use href="/static/images/sprites.svg#github">"""
                    }
                }
            }
        }
    }
}
