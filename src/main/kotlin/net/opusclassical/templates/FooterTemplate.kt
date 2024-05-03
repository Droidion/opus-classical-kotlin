package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.FlowContent
import kotlinx.html.footer
import kotlinx.html.a
import kotlinx.html.img

class FooterTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        footer(classes = "dark:xl:bg-codgray dark:bg-mineshaft flex h-16 w-full max-w-screen-xl items-center justify-center bg-black/20 px-4 xl:bg-white") {
            a(classes = "mx-3", href="https://www.buymeacoffee.com/zunh") {
                attributes["title"] = "Buy me a coffee"
                img(classes = "h-8", src = "/static/images/bmc-button.svg") {
                    attributes["alt"] = "Buy me a coffee"
                    attributes["width"] = "128"
                    attributes["height"] = "36"
                }
            }
            a(classes = "mx-3", href="https://github.com/Droidion/opus-classical-kotlin") {
                attributes["title"] = "GitHub repository"
                img(classes = "icon h-8 w-12", src = "/static/images/github-icon.svg")
            }
        }
    }
}
