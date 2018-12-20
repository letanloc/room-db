package publishing.h.bm.unitest.demo4

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "user")


class User(
        @PrimaryKey(autoGenerate = true)
        var uid: Int,

        @ColumnInfo(name = "first_name")
        var firstName: String? = "",

        @ColumnInfo(name = "last_name")
        var lastName: String? = null,

        @ColumnInfo(name = "age")
        var age: Int = 0
) {
    constructor() : this(0, "", "", 0)
}