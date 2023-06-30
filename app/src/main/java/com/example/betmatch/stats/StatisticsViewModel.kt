package com.example.betmatch.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betmatch.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatisticsViewModel : ViewModel() {
  private val repository = Repository()

  private val _stats = MutableLiveData<List<Team>>()
  val stats: LiveData<List<Team>> = _stats



  fun getDefenceStats() {
    viewModelScope.launch(Dispatchers.IO) {
      val response = repository.getDefenceStats()
      _stats.postValue(response.body())
    }
  }

  fun getAttackStats() {
    viewModelScope.launch(Dispatchers.IO) {
      val response = repository.getAttackStats()
      _stats.postValue(response.body())
    }
  }
}