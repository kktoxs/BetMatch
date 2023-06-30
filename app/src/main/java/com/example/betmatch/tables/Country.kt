package com.example.betmatch.tables

import com.google.gson.annotations.SerializedName

data class Country(
  val name: String,
  val dates: String,
  val category: String,
  @SerializedName("players_count")
  val playersCount: Int,
  val icon: String,
  val data: Map<String, Data>
) {

  data class Data(
    @SerializedName("Команда")
    val team: String,
    @SerializedName("Игры")
    val games: Int,
    @SerializedName("В")
    val win: Int,
    @SerializedName("Н")
    val draw: Int,
    @SerializedName("П")
    val lose: Int,
    @SerializedName("Мячи")
    val balls: String,
    @SerializedName("Очки")
    val points: String,
    @SerializedName("% очков")
    val percent: String
  )
}