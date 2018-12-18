package publishing.h.bm.unitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDemo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, "HEKKI", Toast.LENGTH_SHORT).show()
                var a = edtA.text.toString()
                var b = edtB.text.toString()

                if (a.isNullOrEmpty() && b.isNullOrEmpty()) {
                } else {
                    var intA = a.toInt()
                    var intB = b.toInt()
                    txtSum.text = "${sum(intA, intB)}"
                }
            }
        })
    }

    private fun sum(a: Int, b: Int): Int = a + b

    companion object {


    }
}
