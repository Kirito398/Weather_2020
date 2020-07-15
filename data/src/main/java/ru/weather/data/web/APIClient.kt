package ru.weather.data.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.weather.data.DataBaseConstantUtils

class APIClient {
    fun getClient(): API {
        val retrofit = Retrofit.Builder()
            .baseUrl(DataBaseConstantUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(API::class.java)
    }
}