package com.anushka.bindingdemo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.anushka.bindingdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val button = findViewById<Button>(R.id.submit_button)
        val button = binding.submitButton
        button.setOnClickListener {
            displayGreeting()
        }
    }
    private fun displayGreeting() {
        binding.apply {
            val messageView = greetingTextView
            val nameText = nameEditText
            messageView.text="Hello! "+nameText.text
        }
        /*val messageView = findViewById<TextView>(R.id.greeting_text_view)
        val nameText = findViewById<EditText>(R.id.name_edit_text)

        messageView.text = "Hello! "+ nameText.text*/
    }
}