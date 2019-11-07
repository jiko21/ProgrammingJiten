package app.kojima.jiko.gengojiten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
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
    val helloList: Array<Int> = arrayOf(
        R.string.kotlin_hello,
        R.string.js_hello,
        R.string.cpp_hello,
        R.string.python_hello
    )
    val detailList: Array<Int> = arrayOf(
        R.string.kotlin_detail,
        R.string.js_detail,
        R.string.cpp_detail,
        R.string.python_detail
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = getIntent()
        val index = intent.getIntExtra("INDEX", 0)
        langText.text = titleList[index]
        langDetail.setText(detailList[index])
        langHello.setText(helloList[index])
        iconImage.setImageResource(imgList[index])
        backButton.setOnClickListener {
            finish()
        }
    }
}
