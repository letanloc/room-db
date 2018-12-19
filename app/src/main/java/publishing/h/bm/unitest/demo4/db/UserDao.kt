package publishing.h.bm.unitest.demo4.db

import androidx.room.Dao
import androidx.room.Query
import publishing.h.bm.unitest.demo4.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

}