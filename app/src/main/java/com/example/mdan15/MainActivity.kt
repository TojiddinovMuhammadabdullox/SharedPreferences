package com.example.mdan15

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mdan15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
         sharedPreferences =
            getPreferences(MODE_PRIVATE)   //getPregerences faqat bitta activityda saqlab qoladi malumotlarni
        counter = sharedPreferences.getInt("count", 0)
        setContentView(binding.root)
        binding.counterTv.text = counter.toString()
        binding.incrementbtn.setOnClickListener {
            counter++
            binding.counterTv.text = counter.toString()
            sharedPreferences.edit().putInt("count", counter).apply()

        }
    }

    override fun onStop() {
        sharedPreferences.edit().putInt("count",counter).apply()
        super.onStop()
    }
}