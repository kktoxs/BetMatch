package com.example.betmatch

import com.example.betmatch.news.News
import com.example.betmatch.stats.Team
import com.example.betmatch.tables.Country
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
  @GET("data_tournament_tables.json")
  suspend fun getTournamentTable(): Response<List<Country>>

  @GET("data_statistic_defense.json")
  suspend fun getDefenceStats(): Response<List<Team>>

  @GET("data_statistic_attack.json")
  suspend fun getAttackStats(): Response<List<Team>>

  @GET("http://84.38.181.162/api/news.json")
  suspend fun getNews(): Response<List<News>>

  companion object {
    private const val BASE_URL = "http://84.38.181.162/api/"
    fun create(): ApiService {
      val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
      return retrofit.create(ApiService::class.java)

    }

  }
}