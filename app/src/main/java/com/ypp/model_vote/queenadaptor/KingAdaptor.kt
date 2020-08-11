package com.ypp.model_vote.queenadaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ypp.model_vote.R
import com.ypp.model_vote.model.QueenItem
import kotlinx.android.synthetic.main.king_item.view.*

class KingAdaptor(var kingArrayList: ArrayList<QueenItem>):RecyclerView.Adapter<KingAdaptor.KingViewHolder>() {
    class KingViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindKing(king:QueenItem){

            Picasso.get().load(king.img_url).into(itemView.kingImage)
            itemView.idText.text=king.id
            itemView.kingNameText.text=king.name
            itemView.kingClass.text=king.`class`
            itemView.kingCount.text=king.vote_count.toString()
            itemView.kingStatus.text=king.vote_time_status.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.king_item,parent,false)
        return KingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kingArrayList.size
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
        holder.bindKing(kingArrayList[position])
    }
}