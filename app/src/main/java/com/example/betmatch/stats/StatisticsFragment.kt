package com.example.betmatch.stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betmatch.R
import com.example.betmatch.databinding.FragmentStatisticsBinding


class StatisticsFragment : Fragment() {
  private val viewModel by lazy {
    ViewModelProvider(this)[StatisticsViewModel::class.java]
  }
  private val binding by lazy {
    FragmentStatisticsBinding.inflate(layoutInflater)
  }

  private val playersAdapter by lazy {
    TeamsAdapter()
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
    viewModel.stats.observe(viewLifecycleOwner) {
      playersAdapter.setPlayerList(it)
    }
    setupRecycler()
    viewModel.getDefenceStats()
  }


  private fun setupRecycler() {
    binding.playersRv.apply {
      adapter = playersAdapter
      layoutManager = LinearLayoutManager(requireContext())
    }
  }

  private fun setClickListeners() {
    binding.attack.setOnClickListener {
      viewModel.getAttackStats()
      binding.defence.background.setTint(ContextCompat.getColor(requireContext(), R.color.dark_blue))
      it.background.setTint(ContextCompat.getColor(requireContext(), R.color.orange))
      it.isEnabled = false
      binding.defence.isEnabled = true
    }

    binding.defence.setOnClickListener {
      viewModel.getDefenceStats()
      binding.attack.background.setTint(ContextCompat.getColor(requireContext(), R.color.dark_blue))
      it.background.setTint(ContextCompat.getColor(requireContext(), R.color.orange))
      it.isEnabled = false
      binding.attack.isEnabled = true
    }
  }
}