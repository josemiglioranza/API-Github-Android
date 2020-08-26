package com.example.myapplication

import com.google.gson.annotations.SerializedName

class PostRepositoryOficial {

    data class PostsRepoOfi(

        @SerializedName("name")
        var name : String,

        @SerializedName("full_name")
        var full_name : String,

        @SerializedName("login")
        var login : String,

        @SerializedName("description")
        var description : String
    )
}