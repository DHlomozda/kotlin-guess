package com.example.kotlin_guess.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.kotlin_guess.R
import com.example.kotlin_guess.databinding.GameFragmentBinding

class GameFragment: Fragment() {

    private var word = ""
    private  var score = 0
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private lateinit var binding: GameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false
        )
        resetList()
        nextWord()
        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        updateScoreText()
        updateWordText()
        return binding.root
    }

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    private fun gameFinished() {
        val action = GameFragmentDirections.actionGameToScore(score)
        findNavController(this).navigate(action)
    }

    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            gameFinished()
        } else {
            word = wordList.removeAt(0)
        }
        updateWordText()
        updateScoreText()
    }
    private fun onSkip() {
        score--
        nextWord()
    }

    private fun onCorrect() {
        score++
        nextWord()
    }

    private fun updateWordText() {
        binding.wordText.text = word

    }

    private fun updateScoreText() {
        binding.scoreText.text = score.toString()
    }

}