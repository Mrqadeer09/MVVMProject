package com.qadeer.mvvmproject.data.remote.repository

import com.qadeer.mvvmproject.data.remote.ApiService
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val apiService: ApiService,
) {


    suspend fun getUserList() = apiService.getUserList()


}