package publishing.h.bm.unitest.demo3.local

import io.reactivex.Flowable
import publishing.h.bm.unitest.demo3.UserModel
import publishing.h.bm.unitest.demo3.db.user.UserDao
import publishing.h.bm.unitest.demo3.responstory.UserResource

class UserLocalResource : UserResource {

    override fun getAllUser(): Flowable<List<UserModel>> {
        return userDao.getAll()
    }

    companion object {
        private var instance: UserLocalResource? = null
        fun getInstance(userDao: UserDao): UserLocalResource {
            if (instance == null) {
                instance = UserLocalResource(userDao)
            }

            return instance as UserLocalResource
        }
    }

    private var userDao: UserDao

    constructor(usrDao: UserDao) {
        userDao = usrDao
    }

    override fun insert(user: UserModel) {
        userDao.addUser(user)
    }

    override fun update(user: UserModel) {
        userDao.updateData(user)
    }

    override fun delete(user: UserModel) {
        userDao.deleteData(user)
    }

//    override fun getAllUser() {
//        userDao.getAll()
//    }

    override fun getUserByUserId(userId: Int): Flowable<UserModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserByName(userName: String): Flowable<List<UserModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}