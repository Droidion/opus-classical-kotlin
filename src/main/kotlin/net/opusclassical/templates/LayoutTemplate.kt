package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.*

class LayoutTemplate: Template<HTML> {
    private val footer = TemplatePlaceholder<FooterTemplate>()
    private val header = TemplatePlaceholder<HeaderTemplate>()
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
            link("/static/images/apple-touch-icon.png", "icon", "image/png") {
                sizes = "180x180"
            }
            link("/static/images/favicon-32x32.png", "icon", "image/png") {
                sizes = "32x32"
            }
            link("/static/images/favicon-16x16.png", "icon", "image/png") {
                sizes = "16x16"
            }
            link("/static/images/safari-pinned-tab.svg", "mask-icon") {
                attributes["color"] = "#fff"
            }
            link("/static/site.webmanifest", "manifest")
            link("/static/images/apple-touch-icon.png", "apple-touch-icon-precomposed",  "image/png") {
                sizes = "180x180"
            }
            link("/static/images/favicon.ico", "icon", "image/x-icon")
            link("/static/styles.css", "stylesheet", "text/css")
            script(src = "/static/init-switcher.js") {
                attributes["defer"] = "defer"
            }
            title {
                insert(titleText)
            }

        }
        body {
            script(src = "/static/theme-loader.js") {}
            div {
                classes = setOf("grid", "min-h-screen", "w-full", "grid-rows-[auto_1fr_auto]", "justify-items-center")
                insert(HeaderTemplate(), header)
                main {
                    classes = setOf("main", "flex", "w-full", "max-w-screen-xl", "flex-col", "overflow-auto", "px-4", "pb-4")
                    insert(content)
                }
                insert(FooterTemplate(), footer)
            }
        }
    }
}
