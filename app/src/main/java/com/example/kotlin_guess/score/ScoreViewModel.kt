package com.example.kotlin_guess.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(private val finalScore: Int): ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score


    init {
        Log.i("ScoreViewModel", "final score: $finalScore")
        _score.value = finalScore
    }
}