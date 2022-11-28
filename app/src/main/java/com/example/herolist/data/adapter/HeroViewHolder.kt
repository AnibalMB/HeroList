package com.example.herolist.data.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.herolist.R
import com.example.herolist.data.HeroItem
import com.example.herolist.databinding.ItemHeroBinding

class HeroViewHolder(view: View):RecyclerView.ViewHolder(view)  {
    val binding = ItemHeroBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(heroModel: HeroItem, onClickListener: (HeroItem) -> Unit) {
        Glide.with(binding.ivHeroAvatar).load(heroModel.images.xs).into(binding.ivHeroAvatar)

        binding.tvHeroName.text = heroModel.name
        binding.tvIntelligence.text = "Intelligence: ${heroModel.powerstats.intelligence}"
        binding.tvStrength.text = "Strength: ${heroModel.powerstats.strength}"
        binding.tvSpeed.text = "Speed: ${heroModel.powerstats.speed}"
        binding.tvDurability.text = "Durability: ${heroModel.powerstats.durability}"
        binding.tvPower.text = "Power: ${heroModel.powerstats.power}"
        binding.tvCombat.text = "Combat: ${heroModel.powerstats.combat}"
        /*

        binding.tvIntelligence.text = "${R.string.stat_intelligence} ${heroModel.powerstats.intelligence}"
        binding.tvStrength.text = "${R.string.stat_strength} ${heroModel.powerstats.strength}"
        binding.tvSpeed.text = "${R.string.stat_speed} ${heroModel.powerstats.speed}"
        binding.tvDurability.text = "${R.string.stat_durability} ${heroModel.powerstats.durability}"
        binding.tvPower.text = "${R.string.stat_power} ${heroModel.powerstats.power}"
        binding.tvCombat.text = "${R.string.stat_combat} ${heroModel.powerstats.combat}"
         */

        itemView.setOnClickListener {
            onClickListener(heroModel)
        }
    }
}