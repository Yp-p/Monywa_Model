package com.ypp.model_vote.API

import com.ypp.model_vote.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface QueenApiInterface{
    @GET("queen")
    fun getPost():Call<ArrayList<QueenItem>>
}