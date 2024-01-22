package com.qadeer.mvvmproject.data.remote


import com.qadeer.mvvmproject.data.models.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET()
    suspend fun getUserList(): Response<ArrayList<UserModel>>

}