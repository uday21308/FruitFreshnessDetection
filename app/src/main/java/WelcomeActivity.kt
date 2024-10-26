package com.example.fruitfreshnessdetection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast





class WelcomeActivity : AppCompatActivity() {

    // List of valid usernames and passwords (hardcoded for demonstration)
    private val validUsers = mutableMapOf(
        "mad" to "mad123",
        "uday" to "1234",
        "tejo" to "tejo123"
    )
    
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Initialize the EditText fields
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        // Login button click listener
        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if username and password are not empty
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Validate the username and password
                if (isValidCredentials(username, password)) {
                    // Credentials are correct, proceed to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Finish the welcome activity
                } else {
                    // Show an error message if the credentials are incorrect
                    Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Show a message if the fields are empty
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to check if the entered credentials are valid
    private fun isValidCredentials(username: String, password: String): Boolean {
        return validUsers[username] == password
    }
}
