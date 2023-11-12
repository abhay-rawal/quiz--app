package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quizapp.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater);
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.submit.setOnClickListener{
            val checkboxState = binding.correct.isChecked.toString()
            val radioButtonState = binding.rg.checkedRadioButtonId
            var score = 0
            if (checkboxState == "true"){
                score += 1
            }
            if (radioButtonState == R.id.correctRadio){
                score += 1
            }
            var  toalPercentage = (score/2.0)*100

            var builder = AlertDialog.Builder(this)
            val cal = Calendar.getInstance();
            val date = cal.get(Calendar.DATE)
            val time = cal.get(Calendar.HOUR_OF_DAY)
            builder.setTitle("Result");
            builder.setMessage("“CongratulationCons! You submitted on the $date and $time, you achieved $toalPercentage")
            builder.setPositiveButton("OK"){dialogInterface, which ->
                dialogInterface.dismiss()
            }
            builder.create().show()

        }
        binding.reset.setOnClickListener{
            binding.correct.isChecked = false
            binding.checkBox.isChecked = false
            binding.checkBox3.isChecked = false
            binding.checkBox4.isChecked = false
            binding.rg.clearCheck()
        }
    }
}