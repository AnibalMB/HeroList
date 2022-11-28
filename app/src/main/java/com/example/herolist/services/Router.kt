package com.example.herolist.services

class Router {

    private val urlBase:String = "https://akabab.github.io/superhero-api/api/"

    /**
     * GET base url
     */
    fun getUrlBase():String {
        return this.urlBase
    }

    /**
     * GET all superheroes
     */
    fun getAllSuperheroes():String{
        return "all.json"
    }

    /**
     * GET superhero powerstats by id
     */
    fun getSuperheroePowerStats(idHero: String):String{
        return "powerstats/$idHero.json"
    }

    /**
     * GET superhero appearance by id
     */
    fun getSuperheroeAppearance(idHero: String):String{
        return "appearance/$idHero.json"
    }

    /**
     * GET superhero biography by id
     */
    fun getSuperheroeBiography(idHero: String):String{
        return "biography/$idHero.json"
    }

    /**
     * GET superhero connections by id
     */
    fun getSuperheroeConnection(idHero: String):String{
        return "connections/$idHero.json"
    }

    /**
     * GET superhero work by id
     */
    fun getSuperheroeWork(idHero: String):String{
        return "work/$idHero.json"
    }

}