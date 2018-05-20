package sample.qiitaclient.model

import android.os.Parcel
import android.os.Parcelable


data class Article(val id: String,
                   val title: String,
                   val url: String,
                   val user: User) : Parcelable {

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeString(id)
            writeString(title)
            writeString(url)
            writeParcelable(user, flags)
        }
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {

            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)

            override fun createFromParcel(source: Parcel): Article = source.run {
                Article(readString(), readString(), readString(), readParcelable(Article::class.java.classLoader))
            }
        }
    }
}


