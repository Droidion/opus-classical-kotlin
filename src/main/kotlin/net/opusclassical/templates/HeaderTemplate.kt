package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.*

class HeaderTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        val logo = TemplatePlaceholder<LogoTemplate>()
        val switcher = TemplatePlaceholder<DarkModeSwitcher>()
        header {
            classes = setOf("dark:xl:bg-codgray", "dark:bg-mineshaft", "top-0", "z-10", "flex", "h-16", "w-full", "max-w-screen-xl", "items-center", "justify-between", "bg-black/20", "px-4", "xl:sticky", "xl:h-24", "xl:bg-white")
            insert(LogoTemplate(), logo)
            nav {
                classes = setOf("menu", "flex", "items-center")
                div {
                    classes = setOf("mr-4")
                    insert(DarkModeSwitcher(), switcher)
                }
            }
        }
    }
}
