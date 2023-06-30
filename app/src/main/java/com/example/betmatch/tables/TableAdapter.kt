package com.example.betmatch.tables

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.betmatch.R

class TableAdapter(val context: Context, private var country: Country) :
  RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

  class TableViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val position: TextView = view.findViewById(R.id.pos)
    val teamName: TextView = view.findViewById(R.id.team_name)
    val games: TextView = view.findViewById(R.id.games)
    val draws: TextView = view.findViewById(R.id.draw)
    val loses: TextView = view.findViewById(R.id.lose)
    val balls: TextView = view.findViewById(R.id.balls)
    val points: TextView = view.findViewById(R.id.points)
    val wins: TextView = view.findViewById(R.id.win)
    val line: View = view.findViewById(R.id.place)
    val logo: ImageView = view.findViewById(R.id.logo)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
    return TableViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
    )
  }

  override fun getItemCount(): Int = country.data.size

  override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
    val team = country.data[(position + 1).toString()]!!
    holder.position.text = (position + 1).toString()
    holder.teamName.text = team.team
    holder.balls.text = team.balls
    holder.loses.text = team.lose.toString()
    holder.draws.text = team.draw.toString()
    holder.games.text = team.games.toString()
    holder.points.text = team.points
    holder.wins.text = team.win.toString()

    when (position) {
      in 0..1 -> holder.line.setBackgroundColor(ContextCompat.getColor(context, R.color.green))
      in 2..3 -> holder.line.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
      in country.data.size - 4..country.data.size - 3 -> holder.line.setBackgroundColor(
        ContextCompat.getColor(context, R.color.pink)
      )

      in country.data.size - 2..country.data.size - 1 -> holder.line.setBackgroundColor(
        ContextCompat.getColor(context, R.color.red)
      )

      else -> holder.line.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
    }
  }
}