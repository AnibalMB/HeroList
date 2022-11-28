package com.example.herolist

import android.content.Intent
import android.content.pm.ModuleInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.herolist.data.Hero
import com.example.herolist.data.HeroItem
import com.example.herolist.data.adapter.HeroAdapter
import com.example.herolist.data.adapter.HeroProvider
import com.example.herolist.databinding.ActivityHomeBinding
import com.example.herolist.services.APIService
import com.example.herolist.services.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val router = Router()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val call = CoroutineScope(Dispatchers.IO).launch {
        loadData()
        }
        runBlocking {
            call.join()
            initRecyclerView()
        }
    }

    fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        binding.recyclerHero.layoutManager = manager
        binding.recyclerHero.adapter = HeroAdapter(HeroProvider.HeroList){
            onItemSelected(
                it
            )
        }
        binding.recyclerHero.addItemDecoration(decoration)
    }

    private fun onItemSelected(hero: HeroItem){
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("heroSelected",hero.id)
        intent.putExtra("heroPosition",HeroProvider.HeroList.indexOf(hero))
        startActivity(intent)
    }

    private suspend fun loadData(){
        val call: Response<Hero> = getResponse().create(APIService::class.java).getAllHeroService(router.getAllSuperheroes())
        if (call.body() != null)
            HeroProvider.HeroList = call.body()!!
    }

    private fun getResponse(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(router.getUrlBase())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}