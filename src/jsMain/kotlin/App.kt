
import api.Weather
import api.WeatherData
import csstype.*
import dom.html.HTMLInputElement
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.document
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.FC
import react.Props
import react.dom.html.ButtonType
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.p
import react.useState

val client = HttpClient(Js)
val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

val App = FC<Props> {

    var loc: WeatherData? by useState(null)

    div {
        className = ClassName("vh-100 d-flex justify-content-center align-items-center flex-column")

        div {
            className = ClassName("d-flex justify-content-center align-items-center flex-column gap-3 bg-light border border-primary rounded")

            div {
                className = ClassName("m-5")


                div {
                    className = ClassName("mb-3")
                    label {
                        htmlFor = "location"
                        className = ClassName("form-label")
                        +"Локація"
                    }

                    input {
                        type = InputType.text
                        className = ClassName("form-control")
                        id = "location"
                    }

                }

                button {

                    onClick = { event ->
                        val location = document.getElementById("location") as HTMLInputElement

                        scope.launch {
                            val response = client.get {
                                url {
                                    protocol = URLProtocol.HTTPS
                                    host = "api.openweathermap.org"
                                    path("data/2.5/weather")
                                    parameters.append("q", location.value)
                                    parameters.append("units", "metrics")
                                    parameters.append("appid", "PUT_YOUR_APP_ID")
                                }
                            }

                            if (response.status.value != 200) return@launch

                            loc = Json.decodeFromString(response.body<String>())

                        }
                    }

                    type = ButtonType.submit
                    className = ClassName("btn btn-primary")

                    +"Пошук по локації"
                }

                if (loc != null) {
                    hr {}
                    p {
                        +"Температура: "
                        +"${(loc!!.main.temp - 273).toInt()}*C"
                    }
                    p {
                        +"Температура здається як: "
                        +"${(loc!!.main.feelsLike - 273).toInt()}*C"
                    }
                    p {
                        +"Швидкість вітру: "
                        +"${loc!!.wind.speed} м/с"
                    }
                    p {
                        +"Вологість: "
                        +"${loc!!.main.humidity}%"
                    }
                }
            }

        }


    }

}
