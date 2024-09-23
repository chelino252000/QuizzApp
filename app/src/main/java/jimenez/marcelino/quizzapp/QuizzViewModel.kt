package jimenez.marcelino.quizzapp

import jimenez.marcelino.quizzapp.Question
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizzViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"


class QuizzViewModel (private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].respuesta

    val currentQuestionText: Int
        get() =  questionBank[currentIndex].questionTextId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    override fun onCleared(){
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }
}