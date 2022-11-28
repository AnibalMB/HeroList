package com.example.herolist.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.herolist.R
import com.example.herolist.data.HeroItem

class HeroAdapter(private val heroList:List<HeroItem>, private val onClickListener: (HeroItem) -> Unit): RecyclerView.Adapter<HeroViewHolder>() {
    /**
     * Draw the elements of list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.item_hero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val item = heroList[position]
        holder.render(item, onClickListener)
    }

    /**
     * Return list hero`s size
     */
    override fun getItemCount(): Int {
        return heroList.size
    }
}