import csstype.FontWeight
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.h1
import react.useState

val App = FC<Props> {

    var clicks by useState(0)

    h1 {
        css {
            fontWeight = FontWeight.bold
        }
        +"Hello, Kotlin/JS!"
    }
    button {
        onClick = {
            clicks++
        }
        +"Clicked: $clicks"
    }
}