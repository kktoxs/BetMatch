package com.example.betmatch

class Repository {
  private val service = ApiService.create()

  suspend fun getTournamentTable() = service.getTournamentTable()

  suspend fun getDefenceStats() = service.getDefenceStats()

  suspend fun getAttackStats() = service.getAttackStats()

  suspend fun getNews() = service.getNews()
}