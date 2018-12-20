package publishing.h.bm.unitest.demo4

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_room_demo.*
import publishing.h.bm.unitest.R
import publishing.h.bm.unitest.demo4.db.AppDatabase
import publishing.h.bm.unitest.demo4.db.UserDao
import java.util.*
import kotlin.collections.ArrayList

class RoomDemoActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    lateinit var dao: UserDao
    lateinit var adapter: publishing.h.bm.unitest.adapter.BaseAdapter
    private lateinit var dbHandler: DbThread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_demo)
        initData()
        getAllData()

        /****/
        btnDelete.setOnClickListener({

        })
        /****/
        btnAdd.setOnClickListener({
            if (edtValue.text.toString().isNullOrEmpty()) {
            } else addUser(edtValue.text.toString())
        })
        /****/
        btnDelete.setOnClickListener({

        })
    }


    private fun initData() {
        dbHandler = DbThread("DBThread")
        dbHandler.start()
        db = AppDatabase.getInstance(this)!!
        dao = db.userDao()
        adapter = publishing.h.bm.unitest.adapter.BaseAdapter()

        var layoutmanager = LinearLayoutManager(this)
        recycle.layoutManager = layoutmanager
        recycle.adapter = adapter
        adapter.initData(ArrayList<User>())
    }

    private fun addUser(name: String) {
        var user = User()
        user.firstName = name
        user.lastName = UUID.randomUUID().toString()
        user.age = 0

        var task = Runnable {
            dao.insert(user)
            var list = dao.getAll() as ArrayList<User>
            runOnUiThread(Runnable {
                kotlin.run {
                    adapter.updateData(list)

                }
            })
        }
        dbHandler.postTask(task)

    }

    private fun getAllData() {


        var task = Runnable {
            var list = dao.getAll() as ArrayList<User>
            adapter.initData(list)


        }
        dbHandler.postTask(task)
    }
//    private class getAllData : AsyncTask<UserDao, Void, ArrayList<User>>() {
//        override fun doInBackground(vararg p0: UserDao?): ArrayList<User> {
//            var list = p0[0]!!.getAllUserdata()
//            return list as ArrayList<User>
//        }
//
//        override fun onPostExecute(result: ArrayList<User>?) {
//            super.onPostExecute(result)
//            var result1 = result
//        }
//
//        override fun onPreExecute() {
//            super.onPreExecute()
//        }
//
//
//    }

    override fun onDestroy() {
        super.onDestroy()
        if (dbHandler != null)
            dbHandler.destroy()
    }

}