package com.example.betmatch.settings

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.betmatch.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
  private val binding by lazy {
    FragmentSettingsBinding.inflate(layoutInflater)
  }
  private lateinit var onBackgroundChangeListener: OnBackgroundChangeListener

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return binding.root
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnBackgroundChangeListener)
      onBackgroundChangeListener = context
    else
      throw RuntimeException()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    if (requireContext().resources.configuration.uiMode and
      Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    )
      binding.themeSwitch.isChecked = true
    binding.changeButton.setOnClickListener {
      onBackgroundChangeListener.changeBackground()
    }

    binding.themeSwitch.setOnCheckedChangeListener { compoundButton, b ->
      if (b)
        onBackgroundChangeListener.changeTheme(true)
      else
        onBackgroundChangeListener.changeTheme(false)
    }
  }

  interface OnBackgroundChangeListener {
    fun changeBackground()
    fun changeTheme(dark: Boolean)
  }
}