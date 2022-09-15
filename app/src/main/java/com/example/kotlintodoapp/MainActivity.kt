package com.example.kotlintodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)

        val adapter = MyAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener(){
            val intent = Intent(application, NewActivity::class.java)
            startActivity(intent)
        }

        var intent = intent
        val title = intent.getStringExtra("taskName")
        val description= intent.getStringExtra("description")
        val deadline = intent.getStringExtra("deadline")


    }
}

