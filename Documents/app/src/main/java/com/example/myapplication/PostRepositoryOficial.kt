package com.example.myapplication

import com.google.gson.annotations.SerializedName

class PostRepositoryOficial {

    class Repository(
        @SerializedName("name") val name: String,
        @SerializedName("forks_count") val numberOfForks: Long,
        @SerializedName("stargazers_count") val numberOfWatchers: Long,
        @SerializedName("owner") val owner: Person,
        @SerializedName("description") val descricao: String
    )

    class PostRepository(
        @SerializedName("items") val items: List<Repository>
    )

    class Person(
        @SerializedName("avatar_url") val photoPath: String,
        @SerializedName("login") val owner: String
    )

}