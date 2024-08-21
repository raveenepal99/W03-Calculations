package au.edu.swin.sdmd.w03_calculations

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val equals = findViewById<Button>(R.id.equals)

        val answerTextView = findViewById<TextView>(R.id.answer)

        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)



        equals.setOnClickListener {

            val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            val num1 = number1.text.toString().toIntOrNull()
            val num2 = number2.text.toString().toIntOrNull()

            if(num1 != null && num2 != null){
                val result = when (selectedRadioButtonId){
                    R.id.radio_plus -> add(num1, num2)
                    R.id.radio_multiply -> multiply(num1, num2)
                    else -> 0
                }
                // TODO: show result on the screen
                answerTextView.text = result.toString()

            }else{
                answerTextView.text = "invalid input"
            }
        }
    }




    // adds two numbers together
    private fun add(num1: Int, num2: Int): Int{
        return num1 + num2
    }

    //multiply
    private fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }

}