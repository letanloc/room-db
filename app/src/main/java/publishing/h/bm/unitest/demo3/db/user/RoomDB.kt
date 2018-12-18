package publishing.h.bm.unitest.demo3.db.user

import androidx.room.RoomDatabase

abstract class RoomDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}
