package com.example.myapplication

import com.google.gson.annotations.SerializedName

class PostRepositoryOficial {

    data class Repository(
        @SerializedName("name") val name: String,
        @SerializedName("forks_count") val numberOfForks: Long,
        @SerializedName("stargazers_count") val numberOfWatchers: Long,
        @SerializedName("owner") val owner: Person,
        @SerializedName("description") val descricao: String
    )

    data class PostRepository(
        @SerializedName("items") val items: List<Repository>
    )

    data class Person(
        @SerializedName("login") val name: String,
        @SerializedName("avatar_url") val photoPath: String
    )
}