package publishing.h.bm.unitest.demo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_room_demo.*
import publishing.h.bm.unitest.R
import publishing.h.bm.unitest.demo4.db.AppDatabase
import publishing.h.bm.unitest.demo4.db.UserDao
import java.util.*

class RoomDemoActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var dao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_demo)
        db = AppDatabase.getInstance(this)!!
        dao = db.userDao()
        /****/
        btnDelete.setOnClickListener({

        })
        /****/
        btnAdd.setOnClickListener({
            if (edtValue.text.toString().isNullOrEmpty()) {
            } else addUser(edtValue.text.toString())
        })

        btnDelete.setOnClickListener({

        })
    }


    private fun addUser(name: String) {
        var user = User().apply {
            firstName = name
            lastName = UUID.randomUUID().toString()
        }
        dao.insert(user)
    }

}