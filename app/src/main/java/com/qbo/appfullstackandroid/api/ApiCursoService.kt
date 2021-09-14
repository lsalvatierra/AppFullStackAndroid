package com.qbo.appfullstackandroid.api

import com.qbo.appfullstackandroid.model.Curso
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiCursoService {

    @POST("curso")
    fun registrarCurso(@Body curso: Curso): Call<Curso>

    @GET("curso")
    fun listarCurso(): Call<List<Curso>>
}