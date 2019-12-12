package at.fh.swengb.loggingviewsandactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import at.fh.swengb.loggingviewsandactivity.LessonListActivity.Companion.EXTRA_LESSON_ID
import kotlinx.android.synthetic.main.activity_lesson_rating.*

class LessonRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_rating)

        val lessonId = intent.getStringExtra(LessonListActivity.EXTRA_LESSON_ID)

        if (lessonId == null) { //wo ist lesson id
            Toast.makeText(this, "No lessonID given", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            val lessonName = LessonRepository.lessonById(lessonId)?.name
            lesson_rating_header.text = lessonName

            rate_lesson.setOnClickListener{
                val ratingValue = lesson_rating_bar.rating.toDouble() //vom lesson_rating.xml
                val feedback = lesson_feedback.text.toString() //vom lesson_rating.xml
                val rating = LessonRating(ratingValue, feedback) //vom lesson_rating.xml

                LessonRepository.rateLesson(lessonId,rating)

                setResult(Activity.RESULT_OK)
                finish()
            }


            lesson_rating_bar.rating.toDouble() //vom lesson_rating.xml
            lesson_feedback.text.toString() //vom lesson_rating.xml
        }

    }

}
