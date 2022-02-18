package com.example.quize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val TAG="MainActivity"
    private val COUNT="Count"
    private lateinit var trueButton:Button
    private lateinit var falseButton: Button
    private lateinit var questionTextview:TextView
    private lateinit var nextButton: ImageButton
    private lateinit var backButton:ImageButton
    private var count:Int=0
    private val questionBank= listOf(
            Question(R.string.question_russia,true),
            Question(R.string.name_france,true),
            Question(R.string.question_babamasha,false),
            Question(R.string.question_baikal,true),
            Question(R.string.question_usa,false)
    )
    private var currentIndex=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Toast.makeText(this,"OnCreate",Toast.LENGTH_LONG).show()
        Log.i(TAG,"OnCreate")
        setTitle(R.string.app_name)
        trueButton=findViewById(R.id.true_button)
        falseButton=findViewById(R.id.false_button)
        questionTextview=findViewById(R.id.question_text_view)
        nextButton=findViewById(R.id.next_button)
        backButton=findViewById(R.id.back_button)
        updateQuestion()
        trueButton.setOnClickListener{view:View->
            checkAnswer(true)
        }
        falseButton.setOnClickListener{view:View->
            checkAnswer(false)
        }
        nextButton.setOnClickListener{view:View->
            backButton.isEnabled=true
            if(currentIndex==questionBank.size-1)
            {
                nextButton.isEnabled=false;
            }
            else {
                currentIndex = (currentIndex + 1) % questionBank.size
                updateQuestion()
            }
        }
        backButton.setOnClickListener { view:View->
            nextButton.isEnabled=true
            if(currentIndex==0)
            {
                backButton.isEnabled=false;
            }
            else {
                currentIndex = (currentIndex - 1) % questionBank.size
                updateQuestion()
            }
        }
        backButton.isEnabled=false;
    }
    private fun updateQuestion()
    {
        val questionTextResId=questionBank[currentIndex].textResId
        questionTextview.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer=questionBank[currentIndex].answer
        val messageResId= if (userAnswer==correctAnswer)
        {
            R.string.correct_toast
        }
        else
        {
            R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show()
        if(userAnswer==correctAnswer) count++;
        Log.d(COUNT,count.toString())
        if(currentIndex==questionBank.size-1)
        {
            var ball:Int=count*100/questionBank.size
            Toast.makeText(this,resources.getText(R.string.procent).toString()+ball+"%",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        //Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        //Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show()
        Log.d(TAG,"onStop")
    }

    override fun onRestart() {
        super.onRestart()
        //Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show()
        Log.d(TAG,"onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show()
        Log.d(TAG,"onDestroy")
    }
}