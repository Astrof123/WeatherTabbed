package com.example.weathertabbed

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@SuppressLint("NewApi")
fun getCurrentDateFormatted(): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru")) // Используем Locale для русского языка
    return currentDate.format(formatter)
}

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    private var currentFragment = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        val shelehovButton: Button = findViewById(R.id.shelehov)
        val irkutskButton: Button = findViewById(R.id.irkutsk)
        val angarskButton: Button = findViewById(R.id.angarsk)

        shelehovButton.setOnClickListener {
            showFragment(ShelehovFragment())
        }

        irkutskButton.setOnClickListener {
            showFragment(IrkutskFragment())
        }

        angarskButton.setOnClickListener {
            showFragment(AngarskFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}