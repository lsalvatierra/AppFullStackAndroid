package com.qbo.appfullstackandroid.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCliente {

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("https://apires-fullstack-la.herokuapp.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: ApiCursoService by lazy {
        buildRetrofit().create(ApiCursoService::class.java)
    }
}