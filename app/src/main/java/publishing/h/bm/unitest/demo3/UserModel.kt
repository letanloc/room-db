package publishing.h.bm.unitest.demo3

import java.util.UUID.randomUUID
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "usersDb")

class UserModel {

    @PrimaryKey
    @ColumnInfo(name = "userid")
    var mId: String? = UUID.randomUUID().toString()

    @ColumnInfo(name = "username")
    var mUserName: String? = null

    @ColumnInfo(name = "last_update")
    var mDate: Date? = Date(System.currentTimeMillis())
}