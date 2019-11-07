package app.kojima.jiko.gengojiten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val SIZE = 4
    val random: Random = Random()
    var index: Int = 0
    val titleList: Array<String> = arrayOf(
        "Kotlin",
        "JavaScript",
        "C++",
        "Python"
    )
    val imgList: Array<Int> = arrayOf(
        R.drawable.kotlin,
        R.drawable.js,
        R.drawable.cpp,
        R.drawable.python
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomButton.setOnClickListener {
            index = random.nextInt(SIZE)
            setImage(index)
        }
        nextButton.setOnClickListener {
            index = (index + 1) % SIZE
            setImage(index)
        }

        beforeButton.setOnClickListener {
            index = (index + SIZE - 1) % SIZE
            setImage(index)
        }

        mainLangImage.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("INDEX", index)
            startActivity(intent)
        }
    }

    fun setImage(index: Int) {
        mainLangText.text = titleList[index]
        mainLangImage.setImageResource(imgList[index])
    }
}
