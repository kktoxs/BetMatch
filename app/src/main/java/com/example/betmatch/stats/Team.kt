package com.example.betmatch.stats

import com.google.gson.annotations.SerializedName

data class Team(
  @SerializedName("Команда")
  val name: String,
  @SerializedName("Турнир")
  val tournament: String,
  @SerializedName("Удары з.и.")
  val kicks: Float,
  @SerializedName("Отборы з.и.")
  val takes: Float,
  @SerializedName("Перехваты з.и.")
  val interceptions: Float,
  @SerializedName("Фолы з.и.")
  val fouls: Float,
  @SerializedName("Офсайды з.и.")
  val offsides: Float,
  @SerializedName("Рейтинг")
  val rating: Float
)
