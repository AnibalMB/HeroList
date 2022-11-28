package com.example.herolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.example.herolist.data.HeroItem
import com.example.herolist.data.adapter.HeroProvider
import com.example.herolist.databinding.ActivityDetailBinding
import com.example.herolist.databinding.ActivityHomeBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val bundle = intent.extras
        val heroID = bundle?.getInt("heroSelected")
        val heroPos = bundle?.getInt("heroPosition")

        val heroSelected = HeroProvider.HeroList.get(heroPos!!)
        setContent(heroSelected)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = "Hero details"



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setContent(hero: HeroItem){
        Glide.with(binding.ivAvatar).load(hero.images.md).into(binding.ivAvatar)
        binding.tvHeroName.text = hero.name
        binding.tvIntelligence.text = "${binding.tvIntelligence.text}:   ${hero.powerstats.intelligence}"
        binding.tvStrength.text = "${binding.tvStrength.text}:   ${hero.powerstats.strength}"
        binding.tvSpeed.text = "${binding.tvSpeed.text}:     ${hero.powerstats.speed}"
        binding.tvDurability.text = "${binding.tvDurability.text}:   ${hero.powerstats.durability}"
        binding.tvPower.text = "${binding.tvPower.text}:     ${hero.powerstats.power}"
        binding.tvCombat.text = "${binding.tvCombat.text}:   ${hero.powerstats.combat}"
        binding.tvHeight.text = "${binding.tvHeight.text}: ${hero.appearance.height}"
        binding.tvRace.text = "${binding.tvRace.text}: ${hero.appearance.race}"
        binding.tvGender.text = "${binding.tvGender.text}: ${hero.appearance.gender}"
        binding.tvWeight.text = "${binding.tvWeight.text}: ${hero.appearance.weight}"
        binding.tvHair.text = "${binding.tvHair.text}: ${hero.appearance.hairColor}"
        binding.tvEyes.text = "${binding.tvEyes.text}: ${hero.appearance.eyeColor}"
        binding.tvAliases.text = "${binding.tvAliases.text}: ${hero.biography.aliases}"
        binding.tvPublisher.text = "${binding.tvPublisher.text}: ${hero.biography.publisher}"
        binding.tvFirstAppearence.text = "${binding.tvFirstAppearence.text}: ${hero.biography.firstAppearance}"
        binding.tvPlaceOfBirth.text = "${binding.tvPlaceOfBirth.text}: ${hero.biography.placeOfBirth}"
        binding.tvAlignment.text = "${binding.tvAlignment.text}: ${hero.biography.alignment}"
        binding.tvFullName.text = "${binding.tvFullName.text}: ${hero.biography.fullName}"
        binding.tvOccupation.text = "${binding.tvOccupation.text}: ${hero.work.occupation}"
        binding.tvBase.text = "${binding.tvBase.text}: ${hero.work.base}"
        binding.tvGroupAff.text = "${binding.tvGroupAff.text}: ${hero.connections.groupAffiliation}"
        binding.tvRelatives.text = "${binding.tvRelatives.text}: ${hero.connections.relatives}"
    }

}