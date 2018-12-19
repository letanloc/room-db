package publishing.h.bm.unitest.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutID() != null) {
            setContentView(getLayoutID())
        }
        createData()
    }

    fun changeLayout() {

    }

    /**
     * abstract
     * */
    abstract fun getLayoutID(): Int

    abstract fun createData()

}
