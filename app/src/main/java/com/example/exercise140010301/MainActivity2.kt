package com.example.exercise140010301

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise140010301.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var bind: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(bind.root)

        val intent = intent

        val name = intent.getStringExtra("name").toString()
        name.also { bind.nameTextView.text = it }

        val family = intent.getStringExtra("family").toString()
        family.also { bind.familyTextView.text = it }


        bind.submitButton.setOnClickListener {
            intent.putExtra("username", bind.username.editText?.text.toString())
            intent.putExtra("email", bind.email.editText?.text.toString())
            setResult(1, intent)
            finish()
        }

    }
}