package de.jan

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.net.URL
import java.util.*

class WeatherCity(private val url: URL, private val okhttp: OkHttpClient) {

    val longitude: Float
    val latitude: Float
    val countrycode: String
    val cityname: String
    val cityid: Long
    private var data: JSONObject

    init {
        data = requestData()
        longitude = data.getJSONObject("coord").getFloat("lon")
        latitude = data.getJSONObject("coord").getFloat("lat")
        countrycode = data.getJSONObject("sys").getString("country")
        cityname = data.getString("name")
        cityid = data.getLong("id")
    }

    fun getDescriptions() : Array<WeatherDescription> {
        val descriptions = arrayListOf<WeatherDescription>()
        val descriptionData = data.getJSONArray("weather")
        for (description in descriptionData) {
            val desc = description as JSONObject
            descriptions.add(WeatherDescription(desc.getString("description"), URL("http://openweathermap.org/img/w/${desc.getString("icon")}.png")))
        }
        return descriptions.toTypedArray()
    }

    fun getTemperature() : Float {
        return data.getJSONObject("main").getFloat("temp")
    }

    fun getFeltTemperature() : Float {
        return data.getJSONObject("main").getFloat("feels_like")
    }

    fun getMaxTemperature() : Float {
        return data.getJSONObject("main").getFloat("temp_max")
    }

    fun getMinTemperature() : Float {
        return data.getJSONObject("main").getFloat("temp_min")
    }

    fun getPressure() : Float {
        return data.getJSONObject("main").getFloat("pressure")
    }

    fun getHumidity() : Float {
        return data.getJSONObject("main").getFloat("humidity")
    }

    fun getWindSpeed() : Float {
        return data.getJSONObject("wind").getFloat("speed")
    }

    fun getWindDegrees() : Float {
        return data.getJSONObject("wind").getFloat("deg")
    }

    fun getCloudiness() : Float {
        return data.getJSONObject("clouds").getFloat("all")
    }

    fun getDateOfCalculation() : Date {
        return Date(data.getLong("dt") * 1000)
    }

    fun getSunrise() : Date {
        return Date(data.getJSONObject("sys").getLong("sunrise") * 1000)
    }

    fun getSunset() : Date {
        return Date(data.getJSONObject("sys").getLong("sunset") * 1000)
    }

    fun reloadData() {
        data = requestData()
    }

    private fun requestData() : JSONObject {
        val request = Request.Builder()
            .url(url)
            .get()
            .build()
        return JSONObject(okhttp.newCall(request).execute().body!!.string())
    }

    override fun toString(): String {
        return "City: $cityname\nCityID: $cityid\nLongitude: $longitude\nLatitude: $latitude\nCountry Code: $countrycode"
    }

}