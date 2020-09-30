package com.example.myapplication

import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostRepoOficial {

    //Aqui eu não preciso deixar chumbado o valor das variáveis
    @GET("/search/repositories")
    fun list(
        @Query("q") language : String,
        @Query("sort") sort: String,
        @Query("page") page: Int?
    ): Call<PostRepositoryOficial.PostRepository>
}