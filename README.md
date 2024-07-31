# My sample Kotlin/JS + React + Ktor + Coroutines + Bootstrap

This app was based on [Weather-App](https://github.com/SolomiyaKS/Weather-App). I am using IR Compiler with Kotlin/JS + React + React-DOM + Kotlin Emotion + Coroutines + Bootstrap + Ktor + Serialization. It was hard project and I killed for this 2 my days.

If you want to start this project, I recommend to replace my API token for Open Weather Map in code. For example:

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
**For start you need to start Gradle task jsBrowserDevelopmentRun and open 0.0.0.0:8080 in your browser.**

