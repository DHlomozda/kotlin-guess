package com.example.kotlin_guess.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlin_guess.R
import com.example.kotlin_guess.databinding.ScoreFragmentBinding

class ScoreFragment: Fragment() {
    private lateinit var viewModelFactory: ScoreViewModelFactory
    private val viewModel by viewModels<ScoreViewModel>{viewModelFactory}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.score_fragment, container, false
        )

        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        
        binding.scoreText.text = viewModel.score.value.toString()

        binding.playAgainButton.setOnClickListener { onPlayAgain() }
        return binding.root
    }

    private fun onPlayAgain() {
        findNavController().navigate(ScoreFragmentDirections.actionRestart())
    }
}