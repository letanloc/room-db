package publishing.h.bm.unitest.demo3.responstory

import io.reactivex.Flowable
import publishing.h.bm.unitest.demo3.UserModel

interface UserResource {
    fun insert(user: UserModel)
    fun update(user: UserModel)
    fun delete(user: UserModel)
    /****/
    fun getUserByUserId(userId: Int): Flowable<UserModel>
    fun getUserByName(userName: String): Flowable<List<UserModel>>
    fun getAllUser(): Flowable<List<UserModel>>

}