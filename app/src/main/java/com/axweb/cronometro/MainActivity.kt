package com.axweb.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.axweb.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btStart.setOnClickListener {
            startTimer()
        }
        binding.btPausa.setOnClickListener {
            pauseTimer()
        }
        binding.btReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        if (!running) {
            binding.chronometer.base = SystemClock.elapsedRealtime() - pause
            binding.chronometer.start()
            running = true
        }
    }

    private fun pauseTimer() {
        if (running) {
            binding.chronometer.stop()
            pause = SystemClock.elapsedRealtime() - binding.chronometer.base
            running = false
        }
    }

    private fun resetTimer() {
        binding.chronometer.base = SystemClock.elapsedRealtime()
        pause = 0
    }
}