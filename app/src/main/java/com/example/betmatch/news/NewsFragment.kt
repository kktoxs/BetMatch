package com.example.betmatch.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betmatch.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {
  private val viewModel by lazy {
    ViewModelProvider(this)[NewsViewModel::class.java]
  }
  private val binding by lazy {
    FragmentNewsBinding.inflate(layoutInflater)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.news.observe(viewLifecycleOwner){
      setupRecycler(it)
    }
    viewModel.getNews()
  }

  private fun setupRecycler(news: List<News>){
    binding.newsRv.apply {
      adapter = NewsAdapter(requireContext(), news)
      layoutManager = LinearLayoutManager(requireContext())
    }
  }
}