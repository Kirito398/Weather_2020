package ru.weather.data.models

import com.google.gson.annotations.SerializedName

data class ForeCastGsonModel(
    @SerializedName("list")
    val items: List<CityGsonModel>
) {
}