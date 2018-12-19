package publishing.h.bm.unitest.demo3.responstory

import androidx.room.Room
import io.reactivex.Flowable
import publishing.h.bm.unitest.demo3.UserModel
import publishing.h.bm.unitest.demo3.db.user.RoomDB

class UserResponStory : UserResource {
    private lateinit var userResource: UserResource
    private lateinit var roomDb: RoomDB

    companion object {
        lateinit var instance: UserResponStory
        fun getInstance(localDataSource: UserResource): UserResponStory {
            if (instance == null) {
                instance = UserResponStory(localDataSource)
            }
            return instance
        }
    }

    constructor(localDataSource: UserResource) {
        this.userResource = localDataSource
    }

    /**
     * ------------
     * **/


    override fun getUserByUserId(userId: Int): Flowable<UserModel> {
        return userResource.getUserByUserId(userId)
    }

    override fun getUserByName(userName: String): Flowable<List<UserModel>> {
        return userResource.getUserByName(userName)
    }

    override fun getAllUser(): Flowable<List<UserModel>> {
        return userResource.getAllUser()
    }

    override fun insert(user: UserModel) {
        userResource.insert(user)
    }

    override fun update(user: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(user: UserModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}