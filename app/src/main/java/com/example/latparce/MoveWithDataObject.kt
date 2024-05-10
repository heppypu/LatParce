package com.example.latparce

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveWithDataObject : AppCompatActivity() {
    companion object {
        const val  EXTRA_PERSON = "Extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move_with_data_object)

        val tvObject : TextView = findViewById(R.id.tv_object_received)
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person1>(
                EXTRA_PERSON,
                Person1::class.java
            )
        } else {
            intent.getParcelableExyra<Person1>(EXTRA_PERSON)
        }
        if (person != null){
            val text = "Name : ${person.name.toString()},\nEmail :
            ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            tvObject.text = text
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}