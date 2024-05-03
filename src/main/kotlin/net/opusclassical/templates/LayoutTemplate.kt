package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.*

class LayoutTemplate: Template<HTML> {
    private val footer = TemplatePlaceholder<FooterTemplate>()
    val content = Placeholder<FlowContent>()
    val titleText = Placeholder<TITLE>()
    override fun HTML.apply() {
        head {
            meta(charset = "utf-8")
            meta("viewport", "width=device-width, initial-scale=1.0")
            meta("description", "Catalogue for streaming classical music.")
            meta("msapplication-TileColor", "#da532c")
            meta("theme-color", "#ffffff") {
                attributes["media"] = "(prefers-color-scheme: light)"
            }
            meta("theme-color", "#1a1a1a") {
                attributes["media"] = "(prefers-color-scheme: dark)"
            }
            meta("color-scheme", "dark light")
            link(rel = "icon", type = "image/png", href = "/static/images/apple-touch-icon.png") {
                attributes["sizes"] = "180x180"
            }
            link(rel = "icon", type = "image/png", href = "/static/images/favicon-32x32.png") {
                attributes["sizes"] = "32x32"
            }
            link(rel = "icon", type = "image/png", href = "/static/images/favicon-16x16.png") {
                attributes["sizes"] = "16x16"
            }
            link(rel = "mask-icon", href = "/static/images/safari-pinned-tab.svg") {
                attributes["color"] = "#fff"
            }
            link(rel = "manifest", href = "/static/site.webmanifest")
            link(rel = "apple-touch-icon-precomposed", type = "image/png", href = "/static/images/apple-touch-icon.png") {
                attributes["sizes"] = "180x180"
            }
            link(rel = "icon", type = "image/x-icon", href = "/static/images/favicon.ico") {}
            link(rel = "stylesheet", href = "/styles.css", type = "text/css")
            link(rel = "stylesheet", href = "/static/styles.css", type = "text/css")
            script(src = "/static/init-switcher.js") {}
            title {
                insert(titleText)
            }

        }
        body {
            script(src = "/static/theme-loader.js") {}
            div(classes = "grid min-h-screen w-full grid-rows-[auto_1fr_auto] justify-items-center") {
                main(classes = "main flex w-full max-w-screen-xl flex-col overflow-auto px-4 pb-4") {
                    insert(content)
                }
                insert(FooterTemplate(), footer)
            }
        }
    }
}
