package publishing.h.bm.unitest

import android.content.Context
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import publishing.h.bm.unitest.demo4.db.RoomDatabase
import publishing.h.bm.unitest.demo4.db.UserDao



class TestDatabase {
    private lateinit var userDao: UserDao
    private lateinit var db: RoomDatabase

    @Before
    fun createDb() {
//        val context = ApplicationProvider.getApplicationContext<Context>()

    }
}