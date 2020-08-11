package com.ypp.model_vote.model

import retrofit2.http.Url

data class QueenItem(
    val `class`: String,
    val id: String,
    val img_url:String,
    val name: String,
    val vote_count: Int,
    val vote_time_status: Int
)