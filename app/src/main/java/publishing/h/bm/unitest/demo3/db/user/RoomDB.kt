package publishing.h.bm.unitest.demo3.db.user

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

const val DATABASE_VERSION = 2

@Database(entities = arrayOf(UserDao::class), version = DATABASE_VERSION)
abstract class RoomDB : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private val DATABASE_NAME = "Room_database"
        private var instance: RoomDB? = null
        fun getInstance(context: Context): RoomDB {
            if (instance == null) {
                instance = Room.databaseBuilder(context, RoomDB::class.java!!, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }
    }
}
