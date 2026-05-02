package com.example.imad5112a2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Flashcard : AppCompatActivity() {


    // Questions and their correct answers
    private val questions = arrayOf(
        "South Africa is the only country in the world to have three official capital cities",
        "Table Mountain in Cape Town is the highest mountain peak in South Africa",
        "South Africa has exactly 11 official languages",
        "The world's first successful human-to-human heart transplant was performed in South Africa",
        "South Africa is the only nation to have hosted the FIFA World cup, the Rugby World Cup, and the Cricket World Cup"
    )

    private val answers = booleanArrayOf(true, false, false, true, true)


    // To keep track of the current question index
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        // Connect to layout elements
        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // Show the first question
        questionTextView.text = questions[currentIndex]
        feedbackTextView.text = ""
        Log.d("Flashcard", "Question 1 displayed")

        // Handle TRUE button
        trueButton.setOnClickListener {
            Log.d("Flashcard", "User clicked TRUE")

            if (answers[currentIndex]) {
                feedbackTextView.text = "Correct!"
                Log.d("Flashcard", "Correct answer")
            } else {
                feedbackTextView.text = "Incorrect"
                Log.d("Flashcard", "Incorrect answer")
            }
        }

        // Handle FALSE button
        falseButton.setOnClickListener {
            Log.d("Flashcard", "User clicked FALSE")

            if (!answers[currentIndex]) {
                feedbackTextView.text = "Correct!"
                Log.d("Flashcard", "Correct answer")
            } else {
                feedbackTextView.text = "Incorrect"
                Log.d("Flashcard", "Incorrect answer")
            }
        }

        // Handle NEXT button
        nextButton.setOnClickListener {
            currentIndex++

            if (currentIndex < questions.size) {
                questionTextView.text = questions[currentIndex]
                feedbackTextView.text = ""
                Log.d("Flashcard", "Moved to question ${currentIndex + 1}")
            } else {
                Log.d("Flashcard", "All questions answered, going to Score screen")
                val intent = Intent(this, Score::class.java)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
            }
        }
    }
}