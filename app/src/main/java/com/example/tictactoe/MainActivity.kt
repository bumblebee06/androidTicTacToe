package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class turn
    {
        NOUGHT,
        CROSS
    }
    private var firstturn=turn.CROSS
    private var currentturn=turn.CROSS

    private  var crossScore=0
    private var noughtScore=0

    private var boardlist= mutableListOf<Button>()

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initboard()
    }

    private fun initboard()
    {
        boardlist.add(binding.a1)
        boardlist.add(binding.a2)
        boardlist.add(binding.a3)
        boardlist.add(binding.b1)
        boardlist.add(binding.b2)
        boardlist.add(binding.b3)
        boardlist.add(binding.c1)
        boardlist.add(binding.c2)
        boardlist.add(binding.c3)
    }

    fun boardTapped(view:View)
    {
        if(view !is Button)
            return
        addtoBoard(view)
    }

    private fun addtoBoard(button: Button)
    {
        if(button.text != "")
            return
        if(currentturn==turn.CROSS)
        {
            button.text= CROSS
            currentturn= turn.NOUGHT
        }
        else if(currentturn==turn.NOUGHT)
        {
            button.text= NOUGHT
            currentturn= turn.CROSS
        }
    }
    companion object{
        const val CROSS='X'
        const val NOUGHT='O'
    }
}