package com.example.betmatch.stats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.betmatch.R

class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {
  private var teams = listOf<Team>()

  class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.stats_team_name)
    val league: TextView = view.findViewById(R.id.stats_league)
    val kicks: TextView = view.findViewById(R.id.stats_kicks)
    val takes: TextView = view.findViewById(R.id.stats_takes)
  }

  fun setPlayerList(playersList: List<Team>) {
    teams = playersList
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
    return TeamViewHolder(
      LayoutInflater.from(parent.context)
        .inflate(R.layout.team_stats_item, parent,false)
    )
  }

  override fun getItemCount(): Int = teams.size

  override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
    val team = teams[position]
    holder.name.text = team.name
    holder.league.text = team.tournament
    holder.kicks.text = team.kicks.toString()
    holder.takes.text = team.rating.toString()
  }
}