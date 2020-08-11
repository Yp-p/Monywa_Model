package com.ypp.model_vote.queenadaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.ypp.model_vote.R
import com.ypp.model_vote.model.QueenItem
import kotlinx.android.synthetic.main.queen_item.view.*
import kotlin.coroutines.coroutineContext

class QueenAdaptor(var queenArrayList: ArrayList<QueenItem>):RecyclerView.Adapter<QueenAdaptor.QueenViewHolder>(){
    class QueenViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindQueen(queenItem: QueenItem){


            itemView.queenNameText.text=queenItem.name
            itemView.idText.text=queenItem.id
            itemView.queenClass.text=queenItem.`class`
            itemView.queenCount.text=queenItem.vote_count.toString()
            itemView.queenStatus.text=queenItem.vote_time_status.toString()
            Picasso.get().load(queenItem.img_url).into(itemView.queenImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.queen_item,parent,false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return queenArrayList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {

        holder.bindQueen(queenArrayList[position])

    }
}