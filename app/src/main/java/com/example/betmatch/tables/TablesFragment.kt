package com.example.betmatch.tables

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.betmatch.databinding.FragmentTablesBinding

class TablesFragment : Fragment() {
  private val viewModel by lazy {
    ViewModelProvider(requireActivity())[TablesViewModel::class.java]
  }
  private val countryButtons by lazy {
    mutableListOf<AppCompatButton>().apply {
      add(binding.rus)
      add(binding.eng)
      add(binding.ger)
      add(binding.sp)
    }
  }
  private val binding by lazy {
    FragmentTablesBinding.inflate(layoutInflater)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.getTournamentTable()
    viewModel.tournamentTables.observe(viewLifecycleOwner) {

    }
    setClickListeners()
  }

  private fun setClickListeners() {
    for (button in countryButtons) {
      button.setOnClickListener {
        (it as AppCompatButton).text.toString().apply {
          viewModel.getCountryTable(this)
          findNavController().navigate(
            TablesFragmentDirections.actionTablesFragmentToTableFragment(
              this
            )
          )
        }
      }
    }
  }
}