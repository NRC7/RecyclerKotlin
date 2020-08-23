package com.nrc7.apikotlin.services

import com.nrc7.apikotlin.models.Indicator
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // https://mindicador.cl/api/{tipo_indicador}
    @GET("{tipo_indicador}")
    fun getAllDollarValues(@Path("tipo_indicador") tipo: String): Call<Indicator>
}