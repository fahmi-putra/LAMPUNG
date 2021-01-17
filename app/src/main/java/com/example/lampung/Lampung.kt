package com.example.lampung

import android.os.Parcel
import android.os.Parcelable

data class Lampung(
        var name: String? = "",
        var detail: String? = "",
        var photo: Int = 0
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readInt()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(name)
                parcel.writeString(detail)
                parcel.writeInt(photo)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Lampung> {
                override fun createFromParcel(parcel: Parcel): Lampung {
                        return Lampung(parcel)
                }

                override fun newArray(size: Int): Array<Lampung?> {
                        return arrayOfNulls(size)
                }
        }
}