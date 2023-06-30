package com.example.betmatch.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.betmatch.R

class NewsAdapter(private val context: Context, private val news: List<News>) :
  RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
  class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image: ImageView = view.findViewById(R.id.news_image)
    val title: TextView = view.findViewById(R.id.news_title)
    val text: TextView = view.findViewById(R.id.news_text)
    val date: TextView = view.findViewById(R.id.news_date)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    return NewsViewHolder(
      LayoutInflater.from(parent.context)
        .inflate(R.layout.news_item, parent, false)
    )
  }

  override fun getItemCount(): Int = news.size

  override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
    val article = news[position]
    holder.title.text = article.tittle
    holder.text.text = article.text
    holder.date.text = article.date
    Glide.with(context)
      .load(article.img)
      .into(holder.image)
  }
}