package com.example.myapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Connection private constructor() {

    companion object {
        private val baseUrl = "https://api.github.com/" //Url que vai servir como header do endpoint

        private fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder() //Classe que gerencia com chamadas http, que vai connetar com a internet
            return Retrofit.Builder()
                .baseUrl(baseUrl) //
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create()) //Converter o JSON em classes
                .build()
        }

        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }
    }
}
