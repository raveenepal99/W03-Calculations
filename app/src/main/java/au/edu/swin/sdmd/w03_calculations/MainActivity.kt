package au.edu.swin.sdmd.w03_calculations

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
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



        equals.setOnClickListener {
            val result = add(number1.text.toString(), number2.text.toString())

            // TODO: show result on the screen
            answerTextView.text = result.toString()

        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String): Int = number1.toIntOrNull()!! + number2.toIntOrNull()!!


}