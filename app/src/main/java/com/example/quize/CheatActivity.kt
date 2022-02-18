package com.example.quize

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_ANSWER_IS_TRUE="com.example.quize.answer_is_true"
private const val EXTRA_ANSWER="com.example.quize.answer"
class CheatActivity : AppCompatActivity() {
    private var answerIsTrue=false
    private var question=-1
    private lateinit var answerText:TextView
    private lateinit var showAnswer:TextView
    private lateinit var showButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        answerIsTrue=intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        question=intent.getIntExtra(EXTRA_ANSWER,0)
        answerText=findViewById(R.id.answer_text)
        answerText.text=resources.getString(question).toString()
    }
    companion object{
        fun newIntent(packageContext:Context,answerIsTrue:Boolean,answerQuestion:Int):Intent
        {
            return Intent(packageContext,CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue)
                putExtra(EXTRA_ANSWER,answerQuestion)
            }
        }
    }
}