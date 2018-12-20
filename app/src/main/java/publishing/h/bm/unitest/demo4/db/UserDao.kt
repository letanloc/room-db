package publishing.h.bm.unitest.demo4.db

import androidx.room.Dao
import androidx.room.Query
import publishing.h.bm.unitest.demo4.User
import androidx.room.Delete
import androidx.room.Insert


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user where first_name LIKE  :firstName AND last_name LIKE :lastName")
    fun findByName(firstName: String, lastName: String): User


    @Query("SELECT COUNT(*) from user")
    fun countUsers(): Int

    @Insert
    fun insertAll(vararg users: User)

    @Insert
    fun insert(users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user")
    fun getAllUserdata(): List<User>
}