package carlos.huerta.asignacion4_calculadoraimc_huerta

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var resultadoIMC: Float = 0.0f
    val weight: EditText = findViewById(R.id.weight) as EditText
    val height: EditText = findViewById(R.id.height) as EditText
    val calculate: Button = findViewById(R.id.calculate) as Button
    val imc: TextView = findViewById(R.id.imc) as TextView
    val range: TextView = findViewById(R.id.range) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener {
            calculateIMC()
            imc.setText(resultadoIMC.toString())
            determinateRange()
            range.setText(range.toString())
        }
    }

    fun calculateIMC(): Float {
        return weight.text.toString().toFloat() / (height.text.toString().toFloat() * height.text.toString().toFloat())
    }

    //Function
    @SuppressLint("ResourceAsColor")
    fun determinateRange(): TextView {
        if (resultadoIMC < 18.5) {
            range.setText("Bajo peso")
            range.setBackgroundColor(R.color.colorGreen)
        } else if (resultadoIMC >= 18.5 || resultadoIMC <= 24.9) {
            range.setText("Normal")
            range.setBackgroundColor(R.color.colorGreen)
        } else if (resultadoIMC >= 25 || resultadoIMC <= 29.9) {
            range.setText("Sobrepeso")
            range.setBackgroundColor(R.color.colorYellow)
        } else if (resultadoIMC >= 30 || resultadoIMC <= 34.9) {
            range.setText("Obesidad grado 1")
            range.setBackgroundColor(R.color.colorOrange)
        } else if (resultadoIMC >= 35 || resultadoIMC <= 39.9) {
            range.setText("Obesidad grado 2")
            range.setBackgroundColor(R.color.colorRed)
        } else if (resultadoIMC >= 40) {
            range.setText("Obesidad grado 3")
            range.setBackgroundColor(R.color.colorBrown)
        }
        return range
    }
}