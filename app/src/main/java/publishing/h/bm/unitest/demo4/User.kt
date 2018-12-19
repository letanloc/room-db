package publishing.h.bm.unitest.demo4

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "user")
class User {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = 0

    @ColumnInfo(name = "first_name")
    var firstName: String? = null

    @ColumnInfo(name = "last_name")
    var lastName: String? = null

    @ColumnInfo(name = "age")
    var age: Int = 0

//
//    fun getUid(): Int {
//        return uid
//    }
//
//    fun setUid(uid: Int) {
//        this.uid = uid
//    }
//
//    fun getFirstName(): String? {
//        return firstName
//    }
//
//    fun setFirstName(firstName: String) {
//        this.firstName = firstName
//    }
//
//    fun getLastName(): String? {
//        return lastName
//    }
//
//    fun setLastName(lastName: String) {
//        this.lastName = lastName
//    }
//
//    fun getAge(): Int {
//        return age
//    }
//
//    fun setAge(age: Int) {
//        this.age = age
//    }
}