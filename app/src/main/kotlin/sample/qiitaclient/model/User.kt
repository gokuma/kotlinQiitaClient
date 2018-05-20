package sample.qiitaclient.model


import android.os.Parcel
import android.os.Parcelable


data class User(val id: String,
                val name: String,
                val profileImageUrl: String) : Parcelable {

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeString(id)
            writeString(name)
            writeString(profileImageUrl)
        }
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {

            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)

            override fun createFromParcel(source: Parcel): User = source.run {
                User(readString(), readString(), readString())
            }
        }
    }

}