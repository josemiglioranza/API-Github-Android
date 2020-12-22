package com.example.apigithub

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {

    @GET("/search/repositories")
    fun list(
        @Query("q") language: String,
        @Query("sort") sort: String,
        @Query("page") page: Int?
    ): Call<Domain.Items>
}