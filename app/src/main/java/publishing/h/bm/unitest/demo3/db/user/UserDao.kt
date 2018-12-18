package publishing.h.bm.unitest.demo3.db.user

import androidx.room.*
import publishing.h.bm.unitest.demo3.UserModel

@Dao
interface UserDao {

    @Insert
    fun addUser(value: UserModel) {
    }

    @Query("SELECT * FROM usersDb WHERE userid = :id")
    fun getUserById(id: String): UserModel

    @Update
    fun updateData(data: UserModel)

    @Delete
    fun deleteData(data: UserModel)
}