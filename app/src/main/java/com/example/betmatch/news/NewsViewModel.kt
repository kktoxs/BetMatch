package com.example.betmatch.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betmatch.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
  private val repository = Repository()

  private val _news = MutableLiveData<List<News>>()
  val news: LiveData<List<News>> = _news

  fun getNews(){
    viewModelScope.launch(Dispatchers.IO) {
      val response = repository.getNews()
      _news.postValue(response.body())
    }
  }
}