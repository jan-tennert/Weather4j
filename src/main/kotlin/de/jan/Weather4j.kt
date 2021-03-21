package de.jan

import okhttp3.OkHttpClient
import java.net.URL
import java.util.*

/**
 * @param apiKey The api key you can generate at https://openweathermap.org/
 */
class Weather4j(private val apiKey: String) {

    private val okhttp = OkHttpClient()

    fun getCityByName(name: String, unit: Unit = Unit.STANDARD, lang: String = "en") : WeatherCity {
        return WeatherCity(URL("http://api.openweathermap.org/data/2.5/weather?q=$name&appid=$apiKey&units=${unit.key}&lang=$lang"), okhttp)
    }

    fun getCityById(id: Long, unit: Unit = Unit.STANDARD, lang: String = "en") : WeatherCity {
        return WeatherCity(URL("http://api.openweathermap.org/data/2.5/weather?id=$id&appid=$apiKey&units=${unit.key}&lang=$lang"), okhttp)
    }

    fun getCityByCoordinates(lon: Float, lat: Float, unit: Unit = Unit.STANDARD, lang: String = "en") : WeatherCity {
        return WeatherCity(URL("http://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$lon&appid=$apiKey&units=${unit.key}&lang=$lang"), okhttp)
    }

    enum class Unit(val key: String) {
        STANDARD("standard"), METRIC("metric"), IMPERIAL("imperial")
    }

}