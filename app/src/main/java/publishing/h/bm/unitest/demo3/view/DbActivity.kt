package publishing.h.bm.unitest.demo3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_db.*
import publishing.h.bm.unitest.R
import publishing.h.bm.unitest.adapter.Adapter
import publishing.h.bm.unitest.base.BaseActivity
import publishing.h.bm.unitest.demo3.UserModel
import publishing.h.bm.unitest.demo3.db.user.RoomDB
import publishing.h.bm.unitest.demo3.db.user.UserDao
import publishing.h.bm.unitest.demo3.local.UserLocalResource
import publishing.h.bm.unitest.demo3.responstory.UserResponStory

class DbActivity : BaseActivity() {

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var adapter: Adapter
    override fun getLayoutID(): Int = R.layout.activity_db
    private lateinit var userLocalDataSource: UserLocalResource
    private lateinit var userDao: UserDao
    private lateinit var userResponStory: UserResponStory
    private lateinit var database: RoomDB
    private lateinit var list: List<UserModel>

    override fun createData() {
        init()
    }

    private fun init() {
        adapter = Adapter()

        viewManager = LinearLayoutManager(this)
        list = ArrayList<UserModel>()
        lvUser.layoutManager = viewManager
        lvUser.adapter = adapter
        adapter.updateData(list = list as ArrayList<UserModel>)
        database = RoomDB.getInstance(this)
        userDao = database.userDao()
        userLocalDataSource = UserLocalResource.getInstance(userDao)
        userResponStory = UserResponStory.getInstance(userLocalDataSource)
        getAllData()
    }

    private fun getAllData() {
//        Disposable disposable = mUserRepository . getALlUser ()
        var disposable = userResponStory.getAllUser()
        // register on mainthread
        disposable.observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(object : Consumer<List<UserModel>> {
                    override fun accept(t: List<UserModel>) {
                        onUpdateData(t)
                    }
                }, object : Consumer<Throwable> {
                    override fun accept(t: Throwable) {
                        Log.e("ERROR", t.message)
                    }

                })
    }

    private fun onUpdateData(list: List<UserModel>) {
        if (list != null) {
            this.list = list
            adapter.updateData(list = list as ArrayList<UserModel>)

        }
    }

}
