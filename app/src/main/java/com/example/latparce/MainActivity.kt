package com.example.latparce

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity_object -> {
                val person = Person1(
                    "Ani",
                    5,
                    "ani@gmail.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this@MainActivity,
                    MoveWithDataObject::class.java)
                moveWithObjectIntent.putExtra(MoveWithDataObject
                    .EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
        }
    }
}