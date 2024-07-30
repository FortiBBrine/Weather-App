@file:JsModule("react-bootstrap")
@file:JsNonModule

package bootstrap

import react.*

@JsName("Button")
external val Button: ComponentClass<ButtonProps>

external interface ButtonProps : Props {
    var variant: String
    var size: String
}
