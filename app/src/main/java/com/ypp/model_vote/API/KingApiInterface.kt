package com.ypp.model_vote.API

import com.ypp.model_vote.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface KingApiInterface{
    @GET("king")
    fun getPost1():Call<ArrayList<QueenItem>>
}