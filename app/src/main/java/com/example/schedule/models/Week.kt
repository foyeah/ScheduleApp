package com.example.schedule.models

import android.os.Parcel
import android.os.Parcelable
import com.example.schedule.enums.WeekEnum

data class Week(val weekEnum: WeekEnum, val days: ArrayList<Day>) : Parcelable {
    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(weekEnum.ordinal)
        dest.writeTypedList(days)
    }

    companion object CREATOR : Parcelable.Creator<Week> {
        override fun createFromParcel(parcel: Parcel): Week {
            val weekEnum = WeekEnum.values()[parcel.readInt()]
            val days = ArrayList<Day>()
            parcel.readTypedList(days, Day.CREATOR)
            return Week(weekEnum, days)
        }

        override fun newArray(size: Int) : Array<Week?> = arrayOfNulls(size)
    }
}