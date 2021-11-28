package com.example.kotlin_guess.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.kotlin_guess.R
import com.example.kotlin_guess.databinding.GameFragmentBinding

class GameFragment: Fragment() {


    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false
        )

        Log.i("GameFragment", "Called GameViewModel")
        val viewModel : GameViewModel by viewModels()


        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
        }
        binding.skipButton.setOnClickListener {
            viewModel.onSkip()
        }

        viewModel.score.observe(this, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModel.word.observe(this, Observer { newWord ->
            binding.wordText.text = newWord.toString()
        })

        viewModel.eventGameFinish.observe(this, Observer { hasFinish ->
            if(hasFinish){
                gameFinished(viewModel)
                viewModel.gameFinishComplete()
            }

        })

        return binding.root
    }



    fun gameFinished(viewModel: GameViewModel) {
        val action = GameFragmentDirections.actionGameToScore(viewModel.score.value ?: 0)
        findNavController(this).navigate(action)

    }






}