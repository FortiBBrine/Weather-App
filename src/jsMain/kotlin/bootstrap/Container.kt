@file:JsModule("react-bootstrap")
@file:JsNonModule

package bootstrap

import react.*

@JsName("Container")
external val Container: ComponentClass<ContainerProps>

external interface ContainerProps: Props {
    var fiuld: String
}
