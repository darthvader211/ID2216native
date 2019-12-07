package com.darthvader11.bandlink.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.darthvader11.bandlink.R
import com.darthvader11.bandlink.models.Feed
import com.darthvader11.bandlink.models.Search
import com.darthvader11.bandlink.showToast
import kotlinx.android.synthetic.main.item_search.view.*


class SearchAdapter(val context: Context, private val searchs: List<Feed>) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val search = searchs[position]
        holder.setData(search, position)
    }

    override fun getItemCount(): Int {
        return searchs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false)
        return MyViewHolder(view)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentSearch: Feed? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentSearch?.let {

                    context.showToast(currentSearch!!.postTitle + " clicked!")
                }

            }

        }

        fun setData(search: Feed?, pos: Int) {
            search?.let {
                itemView.titleSearch.text = search.postTitle
                itemView.authorSearch.text = search.author
                itemView.locationSearch.text = search.location
                itemView.profilePic.setImageBitmap(search.postPic)
            }
            this.currentSearch = search
            this.currentPosition = pos
        }
    }
}