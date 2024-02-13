package com.example.homework19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework19.list.ListNotesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }
    private fun loadFragment(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, ListNotesFragment())
            .commit()
    }
}