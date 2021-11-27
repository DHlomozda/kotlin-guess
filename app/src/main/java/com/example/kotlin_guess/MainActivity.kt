package com.example.kotlin_guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Добавить логику игры в GameFragment(Запихнем всю логику), попробуэм запустить -> добавить GameViewModel
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}