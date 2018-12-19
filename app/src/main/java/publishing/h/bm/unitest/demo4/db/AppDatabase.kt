package publishing.h.bm.unitest.demo4.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import publishing.h.bm.unitest.demo4.User
import publishing.h.bm.unitest.utils.Constants


@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java!!, "dm")
                            .build()
                }
            }
            return instance!!
        }
    }

    lateinit var context: Context

}