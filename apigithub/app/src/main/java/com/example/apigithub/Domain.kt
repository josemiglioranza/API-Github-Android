package com.example.apigithub

import com.google.gson.annotations.SerializedName

class Domain {

    class Github(
        @SerializedName("name") val name: String,
        @SerializedName("forks_count") val numberOfForks: Long,
        @SerializedName("stargazers_count") val numberOfWatchers: Long,
        @SerializedName("owner") val owner: Person,
        @SerializedName("description") val descricao: String
    )

    class Items(
        @SerializedName("items") val items: List<Github>
    )

    class Person (
        @SerializedName("avatar_url") val photoPath: String,
        @SerializedName("login") val owner: String
    )
}