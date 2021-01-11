package se.magictechnology.pia9vecka2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

            counterNumber = counterNumber + 1

            counterTextView.text = counterNumber.toString()
        }

        var minusButton = findViewById<Button>(R.id.minusButton)

        minusButton.setOnClickListener {

            counterNumber = counterNumber - 1

            if(counterNumber < 0)
            {
                counterNumber = 0
            }

            counterTextView.text = counterNumber.toString()
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

            enteredText.toIntOrNull()?.let { enteredNumber ->
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





}