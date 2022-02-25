package com.example.quize

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

private const val EXTRA_ANSWER_IS_TRUE="com.example.quize.answer_is_true"
private const val EXTRA_ANSWER="com.example.quize.answer"
const val EXTRA_ANSWER_SHOW="com.example.quize.answer_show"
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
        showAnswer=findViewById(R.id.answer_text_view)
        showButton=findViewById(R.id.show_answer_button)
        showButton.setOnClickListener { v:View->
            showAnswer.text=answerIsTrue.toString()
            setAnswerShowResult(true)
        }
    }
    private fun setAnswerShowResult(isAnswerShow:Boolean)
    {
        val data=Intent().apply {
            putExtra(EXTRA_ANSWER_SHOW,isAnswerShow)
        }
        setResult(Activity.RESULT_OK,data)
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