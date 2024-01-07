package com.example.schedule.models

import android.icu.text.SimpleDateFormat
import android.os.Parcel
import android.os.Parcelable
import com.example.schedule.enums.DayEnum

data class Day(val weekDay : DayEnum, val lessons : ArrayList<Lesson>) : Parcelable {
    fun getDay():String{
        return when(weekDay) {
            DayEnum.MONDAY -> "Понедельник"
            DayEnum.TUESDAY -> "Вторник"
            DayEnum.WEDNESDAY -> "Среда"
            DayEnum.THURSDAY -> "Четверг"
            DayEnum.FRIDAY -> "Пятница"
            DayEnum.SATURDAY -> "Суббота"
            DayEnum.SUNDAY -> "Воскресенье"
            else -> "Иначельник"
        }
    }

    fun getInfo(): String {
        var formatter: SimpleDateFormat = SimpleDateFormat("HH:mm")
        if (lessons.size < 1) return "Сегодня чиллим"
        return "${lessons.size} ${getDeclension(lessons.size)} c ${formatter.format(lessons.first().start)} " + "до ${formatter.format(lessons.last().end)}"
    }

    private fun getDeclension(num: Int) : String{
        return if (num == 1) "пара"
        else if (num < 5) "пары"
        else "пар"
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(weekDay.ordinal)
        dest.writeTypedList(lessons)
    }

    companion object CREATOR : Parcelable.Creator<Day> {
        override fun createFromParcel(parcel: Parcel): Day {
            val weekDay = DayEnum.values()[parcel.readInt()]
            val lessons = ArrayList<Lesson>()
            parcel.readTypedList(lessons, Lesson.CREATOR)
            return Day(weekDay, lessons)
        }

        override fun newArray(size: Int): Array<Day?> = arrayOfNulls(size)
    }
}