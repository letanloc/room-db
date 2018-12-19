package publishing.h.bm.unitest.demo3.db.user

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import publishing.h.bm.unitest.demo3.UserModel

const val DATABASE_VERSION = 1

@Database(entities = arrayOf(UserModel::class), version = DATABASE_VERSION, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            if (instance == null) {
                instance = Room.databaseBuilder(context, RoomDB::class.java!!, RoomDB::class.java.toString())
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }
    }
}
