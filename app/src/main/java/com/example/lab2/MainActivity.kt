package com.example.lab2


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    private val listOfChemistry: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

         setContentView(R.layout.activity_main)

        }
    }



    fun click(view:View){

        val textView = findViewById<TextView>(R.id.textView)

        if (view.id == R.id.add){
            val editText = findViewById<EditText>(R.id.toAdd)
            val add = editText.text.toString()
            listOfChemistry.add(add)
            println(listOfChemistry)
            textView.text= getString(R.string.added)
            editText.text.clear()
        }else{
            val editText = findViewById<EditText>(R.id.toGuess)
            val guess = editText.text.toString()

            if(guess.isBlank() || guess.isEmpty()) {
                textView.text = getString(R.string.validateInput)
            }
           else if(  listOfChemistry.isNotEmpty() && listOfChemistry[Random.nextInt(0, listOfChemistry.size)] == guess ){
               textView.text=  "${getString(R.string.congrats)} " + guess
            }else{
                textView.text = "${getString(R.string.sorry)} "+ guess
            }

            editText.text.clear()

        }


    }
}

