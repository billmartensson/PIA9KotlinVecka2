package se.magictechnology.pia9vecka2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var counterNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counterTextView = findViewById<TextView>(R.id.counterTextView)

        counterTextView.text = "0"

        var plusButton = findViewById<Button>(R.id.plusButton)

        plusButton.setOnClickListener {
            calculateNumber("plus")
        }

        var minusButton = findViewById<Button>(R.id.minusButton)

        minusButton.setOnClickListener {
            calculateNumber("minus")
        }

        var resetButton = findViewById<Button>(R.id.resetButton)

        resetButton.setOnClickListener {
            resetCounting()
        }


        var setNumberButton = findViewById<Button>(R.id.setNumberButton)

        setNumberButton.setOnClickListener {

            var numberEditText = findViewById<EditText>(R.id.numberEditText)

            var enteredText = numberEditText.text.toString()

            Log.d("PIA9DEBUG", enteredText)

            /*
            var enteredNumber = enteredText.toIntOrNull()

            if(enteredNumber != null)
            {
                counterNumber = enteredNumber
            }
            */

            /*
            // Motsvarande i Swift:
            if let thenumber = enteredText
            {
                thenumber
            }
             */


            makeNumber(enteredText)?.let {enteredNumber ->
                counterNumber = enteredNumber
            }

            counterTextView.text = counterNumber.toString()

            numberEditText.setText("")

        }


        var goOtherButton = findViewById<Button>(R.id.goOtherButton)

        goOtherButton.setOnClickListener {
            Log.d("PIA9DEBUG", "Lets go")

            var intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("counter", counterNumber)
            startActivity(intent)
        }

    }


    fun resetCounting()
    {
        counterNumber = 0

        var counterTextView = findViewById<TextView>(R.id.counterTextView)

        counterTextView.text = counterNumber.toString()
    }

    fun calculateNumber(calcMode : String)
    {
        if(calcMode == "plus")
        {
            counterNumber = counterNumber + 1
        }
        if(calcMode == "minus")
        {
            counterNumber = counterNumber - 1
        }

        if(counterNumber < 0)
        {
            counterNumber = 0
        }


        var counterTextView = findViewById<TextView>(R.id.counterTextView)
        counterTextView.text = counterNumber.toString()

    }

    fun makeNumber(numbertext : String) : Int?
    {
        var theNumber = numbertext.toIntOrNull()

        if(theNumber == null)
        {
            findViewById<TextView>(R.id.errorTextView).visibility = View.VISIBLE
        } else {
            findViewById<TextView>(R.id.errorTextView).visibility = View.GONE
        }


        return theNumber
    }

}