package ru.weather.data.web

import retrofit2.http.GET
import retrofit2.http.Query
import ru.weather.data.models.CityGsonModel
import ru.weather.data.models.ForeCastGsonModel

interface API {
    @GET("weather")
    suspend fun getCityData(
        @Query("q")
        cityName: String,
        @Query("APPID")
        key: String,
        @Query("units")
        metric: String
    ): CityGsonModel

    @GET("forecast")
    suspend fun getForecast(
        @Query("q")
        cityName: String,
        @Query("APPID")
        key: String,
        @Query("units")
        metric: String
    ): ForeCastGsonModel
}