package com.angoti.projetointegrador4_2020.httpclient

import com.angoti.projetointegrador4_2020.dto.LoginDTO
import com.angoti.projetointegrador4_2020.dto.UserDto
import retrofit2.Call
import retrofit2.http.*

interface EndPoint {

    @GET("users")
    fun obterUsuarios(@Header("Authorization") token: String?): Call<List<UserDto>>

    @POST("users")
    fun cadastraUsuario(@Body user: UserDto): Call<UserDto>

    @POST("auth/login")
    fun login(@Body loginDTO: LoginDTO): Call<LoginDTO>

    @PUT("users/{id}")
    fun alterarUsuario(@Path("id") id: Long, @Header("Authorization") tokenAutenticacao: String, @Body user: UserDto): Call<Void>

    @DELETE("users/{id}")
    fun excluirUsuario(@Path("id") id: Long, @Header("Authorization") tokenAutenticacao: String): Call<Void>
}