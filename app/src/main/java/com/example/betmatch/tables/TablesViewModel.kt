package com.example.betmatch.tables

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betmatch.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TablesViewModel : ViewModel() {
  private val repository = Repository()

  private val _tournamentTables = MutableLiveData<List<Country>>()
  val tournamentTables: LiveData<List<Country>>
    get() = _tournamentTables


  val currentTable = MutableLiveData<Country>()

  fun getTournamentTable() {
    viewModelScope.launch(Dispatchers.IO) {
      val response = repository.getTournamentTable()
      _tournamentTables.postValue(response.body())
      Log.d("vm", response.body().toString())
    }
  }

  fun getCountryTable(country: String) {
    val countryTable = tournamentTables.value?.single { c -> c.name.contains(country) }
    currentTable.postValue(countryTable!!)
    Log.d("getTable", countryTable.toString())
  }
}