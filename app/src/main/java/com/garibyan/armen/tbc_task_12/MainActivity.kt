package com.garibyan.armen.tbc_task_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.garibyan.armen.tbc_task_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}