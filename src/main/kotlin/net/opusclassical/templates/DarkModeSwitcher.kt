package net.opusclassical.templates

import io.ktor.server.html.*
import kotlinx.html.*

class DarkModeSwitcher: Template<FlowContent> {
    override fun FlowContent.apply() {
        div {
            id = "theme-switch"
            classes = setOf("text-cinnamon"," dark:text-lazer"," flex")
            input(InputType.checkBox) {
                id = "switcher"
                name = "switcher"
                classes = setOf("pointer-events-none", "h-0", "w-0", "opacity-0")
                attributes["aria-labelledby"] = "switch-label"
            }
            label {
                id = "switch-label"
                classes = setOf("flex", "h-6", "w-6", "cursor-pointer", "items-center", "justify-center", "overflow-hidden", "duration-150", "hover:scale-125", "xl:h-10", "xl:w-10")
                attributes["for"] = "switcher"
                attributes["aria-label"] = "Switch between dark and light mode"
                svg {
                    classes = setOf("hidden", "h-4", "w-4", "xl:h-5", "xl:w-5", "dark:flex")
                    attributes["height"] = "18"
                    attributes["width"] = "18"
                    attributes["fill"] = "currentColor"
                    unsafe {
                        +"""<use href="/static/images/sprites.svg#lightswitcher">"""
                    }
                }
                svg {
                    classes = setOf("flex", "h-4", "w-4", "xl:h-5", "xl:w-5", "dark:hidden")
                    attributes["height"] = "18"
                    attributes["width"] = "18"
                    attributes["fill"] = "currentColor"
                    unsafe {
                        +"""<use href="/static/images/sprites.svg#darkswitcher">"""
                    }
                }
            }
        }
    }
}