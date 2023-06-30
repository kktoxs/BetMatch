package com.example.betmatch.tables

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betmatch.databinding.FragmentTableBinding

class TableFragment : Fragment() {
  private val args by navArgs<TableFragmentArgs>()
  private val viewModel by lazy {
    ViewModelProvider(requireActivity())[TablesViewModel::class.java]
  }
  private val binding by lazy {
    FragmentTableBinding.inflate(layoutInflater)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.currentTable.observe(viewLifecycleOwner) {
      setUpRecycler(it)
      Log.d("table", it.toString())
    }
    binding.countryName.text = args.countryName
  }

  private fun setUpRecycler(country: Country) {
    val tableAdapter = TableAdapter(requireContext(), country)
    binding.tableRv.apply {
      adapter = tableAdapter
      layoutManager = LinearLayoutManager(requireContext())
    }
  }
}