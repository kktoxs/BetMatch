package com.example.betmatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.betmatch.databinding.FragmentStartBinding


class StartFragment : Fragment() {
  private val binding by lazy {
    FragmentStartBinding.inflate(layoutInflater)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setClickListeners()
  }

  private fun setClickListeners() {
    binding.settingsBtn.setOnClickListener {
      findNavController().navigate(R.id.action_startFragment_to_settingsFragment)
    }
    binding.newsBtn.setOnClickListener {
      findNavController().navigate(R.id.action_startFragment_to_newsFragment)

    }
    binding.statsBtn.setOnClickListener {
      findNavController().navigate(R.id.action_startFragment_to_statisticsFragment)

    }
    binding.tableBtn.setOnClickListener {
      findNavController().navigate(R.id.action_startFragment_to_tablesFragment)
    }
  }

}