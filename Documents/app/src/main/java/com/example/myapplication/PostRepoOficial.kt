package com.example.myapplication

import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostRepoOficial {

    @GET("/search/repositories")
    fun list(
        @Query("q") language : String = "language:Java",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int? = 1
    ): Call<PostRepositoryOficial.PostsRepoOfi>
}