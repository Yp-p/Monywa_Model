package com.ypp.model_vote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ypp.model_vote.API.QueenApiClient
import com.ypp.model_vote.model.QueenItem
import com.ypp.model_vote.queenadaptor.QueenAdaptor
import kotlinx.android.synthetic.main.fragment_king.*
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class queenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_queen, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getPost()
        btnqueen.setOnClickListener {
           findNavController().navigate(R.id.action_queenFragment6_to_kingFragment5)
        }


    }
    fun getPost(){
        val apiClient= QueenApiClient()
        val apiCall=apiClient.postApiService.getPost()
        apiCall.enqueue(object : Callback<ArrayList<QueenItem>> {
            override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<QueenItem>>,
                response: Response<ArrayList<QueenItem>>
            ) {
                queenRecycler.apply {
                    layoutManager= LinearLayoutManager(context)
                    adapter= QueenAdaptor(response.body()!!)
                }
            }

        })
    }


}