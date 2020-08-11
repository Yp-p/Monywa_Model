package com.ypp.model_vote.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class KingApiClient{
    private  val baseUrl="https://ucsmonywaonlinevote.000webhostapp.com/api/"
    private var retrofit:Retrofit?=null
    init {
        if (retrofit==null){
            retrofit=Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
    val postApiService=retrofit!!.create(KingApiInterface::class.java)
}

