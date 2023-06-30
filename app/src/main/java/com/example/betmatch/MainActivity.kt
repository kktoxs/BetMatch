package com.example.betmatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.betmatch.databinding.ActivityMainBinding
import com.example.betmatch.databinding.FragmentSettingsBinding
import com.example.betmatch.settings.SettingsFragment

class MainActivity : AppCompatActivity(), SettingsFragment.OnBackgroundChangeListener {
  private val binding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
  }
  private var currentBackground = R.drawable.background1
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(binding.root)
  }

  override fun changeBackground() {
    val backgrounds = listOf(
      R.drawable.background1,
      R.drawable.background2,
      R.drawable.background3,
    )
    var newBack = backgrounds.random()
    while (currentBackground == newBack)
      newBack = backgrounds.random()
    binding.root.background = getDrawable(newBack)
    currentBackground = newBack
  }

  override fun changeTheme(dark: Boolean) {
    if (dark)
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    else
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
  }

}