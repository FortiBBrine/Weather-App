
import bootstrap.*
import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

val App = FC<Props> {

    div {
        css {
            height = 100.vh
            display = Display.flex
            justifyContent = JustifyContent.center
            alignItems = AlignItems.center
        }

        Button {
            size = "lg"
            variant = "primary"
            +"Click me"
        }
    }
}
