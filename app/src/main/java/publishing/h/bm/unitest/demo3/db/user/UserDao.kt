package publishing.h.bm.unitest.demo3.db.user

import androidx.room.*
import io.reactivex.Flowable
import publishing.h.bm.unitest.demo3.UserModel

@Dao
interface UserDao {

    @Insert
    fun addUser(value: UserModel)

    @Query("SELECT * FROM UserModel WHERE userid = :id")
    fun getUserById(id: String): UserModel

    @Query("SELECT * FROM UserModel")
    fun getAll(): Flowable<List<UserModel>>

    @Update
    fun updateData(data: UserModel)

    @Delete
    fun deleteData(data: UserModel)
}