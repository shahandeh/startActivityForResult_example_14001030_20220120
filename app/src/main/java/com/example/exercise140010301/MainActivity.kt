package com.example.exercise140010301

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise140010301.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val intent = Intent(applicationContext, MainActivity2::class.java)

        bind.submitBtn.setOnClickListener {
            val name = bind.name.editText?.text.toString()
            val family = bind.family.editText?.text.toString()
            intent.putExtra("name", name)
            intent.putExtra("family", family)
            startActivityForResult(intent, 1)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && data != null){
            val username: String = data.getStringExtra("username").toString()
            val email = data.getStringExtra("email").toString()

            username.also { bind.usernameTextView.text = it }
            email.also { bind.emailTextView.text = it }

        }

    }
}