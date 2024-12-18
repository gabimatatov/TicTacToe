package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class PlayerTurn {
        CIRCLE,
        CROSS
    }

    private var firstTurn = PlayerTurn.CROSS
    private var currentTurn = PlayerTurn.CROSS

    lateinit var binding: ActivityMainBinding
    private var boardList = mutableListOf<Button>()

    // onCreate Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initBoard()
    }

    private fun initBoard() {
        boardList.add(binding.buttonX00)
        boardList.add(binding.buttonX01)
        boardList.add(binding.buttonX02)
        boardList.add(binding.buttonX10)
        boardList.add(binding.buttonX11)
        boardList.add(binding.buttonX12)
        boardList.add(binding.buttonX20)
        boardList.add(binding.buttonX21)
        boardList.add(binding.buttonX22)
    }

    fun playerTapped(view: View) {
        if (view !is Button)
            return

        addToBoard(view)
    }

    private fun addToBoard(button: Button){
        if (button.text != "")
            return
        if (currentTurn == PlayerTurn.CIRCLE){
            button.text = "O"
            currentTurn = PlayerTurn.CROSS
        }
        else if (currentTurn == PlayerTurn.CROSS){
            button.text = "X"
            currentTurn = PlayerTurn.CIRCLE
        }
    }
}