package com.example.quize

import android.util.Log
import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {
//    init {
//        Log.d("ViewModel","ViewModel created")
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//    }
    var currentIndex=0
         val questionBank= listOf(
            Question(R.string.question_russia,true),
            Question(R.string.name_france,true),
            Question(R.string.question_babamasha,false),
            Question(R.string.question_baikal,true),
            Question(R.string.question_usa,false)
        )
    var count=0
    val currentQuestionAnswer:Boolean
    get() = questionBank[currentIndex].answer
    val currentQuestiontext:Int
    get() = questionBank[currentIndex].textResId
    fun moveToNext()
    {
        currentIndex=(currentIndex+1)%questionBank.size
    }
    fun moveToBack()
    {
        currentIndex=(currentIndex-1)%questionBank.size
    }

}