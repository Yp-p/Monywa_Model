package com.ypp.model_vote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ypp.model_vote.API.KingApiClient
import com.ypp.model_vote.model.QueenItem
import com.ypp.model_vote.queenadaptor.KingAdaptor
import kotlinx.android.synthetic.main.fragment_king.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_king, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPostKing()
        btnKing.setOnClickListener {
            findNavController().navigate(R.id.action_kingFragment5_to_queenFragment6)
        }
    }
    fun getPostKing(){
        val kingapiClient=KingApiClient()
        val apiCall=kingapiClient.postApiService.getPost1()
        apiCall.enqueue(object : Callback<ArrayList<QueenItem>>{
            override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ArrayList<QueenItem>>,
                response: Response<ArrayList<QueenItem>>
            ) {
                kingRecycler.apply {
                    layoutManager=LinearLayoutManager(context)
                    adapter=KingAdaptor(response.body()!!)
                }
            }

        })
    }


}