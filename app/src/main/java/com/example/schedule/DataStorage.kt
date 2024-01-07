package com.example.schedule

import com.example.schedule.enums.DayEnum
import com.example.schedule.enums.WeekEnum
import com.example.schedule.models.Day
import com.example.schedule.models.Lesson
import com.example.schedule.models.Week
import java.sql.Time
import java.util.Calendar

class DataStorage {
    public fun getWeek(number: WeekEnum): Week {
        return when (number) {
            WeekEnum.FIRST -> Week(WeekEnum.FIRST, firstWeek)
            WeekEnum.SECOND -> Week(WeekEnum.SECOND, secondWeek)
        }
    }

    public fun getDay(number: WeekEnum): Day {

        var day: Day? = null
        day = when (number) {
            WeekEnum.FIRST -> getCurrentDay(firstWeek)
            WeekEnum.SECOND -> getCurrentDay(secondWeek)
        }
        return day ?: Day(DayEnum.TUESDAY, arrayListOf())
    }

    fun getCurrentDay(days: List<Day>): Day? {
        val calendar = Calendar.getInstance()
        val currentDayOfWeek = when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> DayEnum.MONDAY
            Calendar.TUESDAY -> DayEnum.TUESDAY
            Calendar.WEDNESDAY -> DayEnum.WEDNESDAY
            Calendar.THURSDAY -> DayEnum.THURSDAY
            Calendar.FRIDAY -> DayEnum.FRIDAY
            Calendar.SATURDAY -> DayEnum.SATURDAY
            Calendar.SUNDAY -> DayEnum.SUNDAY
            else -> null
        }
        return days.find { it.weekDay == currentDayOfWeek }
    }

    private val firstWeek: ArrayList<Day> = arrayListOf(
        Day(DayEnum.MONDAY, arrayListOf()),
        Day(
            DayEnum.TUESDAY, arrayListOf(
                Lesson("Экономика",
                    Time(15, 0, 0),
                    Time(16, 30, 0),
                    "Ткач Е.С.",
                    "Ауд 221"
                ),
                Lesson(
                    "Базы и хранилища данных",
                    Time(18, 20, 0),
                    Time(19, 50, 0),
                    "Барабанщиков И.В.",
                    "Ауд 413"
                ),
                Lesson(
                    "Базы и хранилища данных",
                    Time(19, 55, 0),
                    Time(21, 25, 0),
                    "Барабанщиков И.В.",
                    "Ауд 413"
                )
            )
        ),
        Day(
            DayEnum.WEDNESDAY, arrayListOf(
                Lesson(
                    "Управление ИТ-проектами и жизненным циклом ПО",
                    Time(18, 20, 0),
                    Time(19, 50, 0),
                    "Сметанина Ю.С.",
                    "Ауд А-15"
                ),
                Lesson(
                    "Управление ИТ-проектами и жизненным циклом ПО",
                    Time(19, 55, 0),
                    Time(21, 25, 0),
                    "Сметанина Ю.С.",
                    "Ауд А-15"
                )
            )
        ),
        Day(
            DayEnum.TUESDAY, arrayListOf(
                Lesson(
                    "Анализ данных",
                    Time(15, 0, 0),
                    Time(16, 30, 0),
                    "Алюков С.В.",
                    "Ауд 132А"
                ),
                Lesson(
                    "Анализ данных",
                    Time(16, 40, 0),
                    Time(18, 10, 0),
                    "Алюков С.В.",
                    "Ауд А-13"
                )
            )
        ),
        Day(
            DayEnum.FRIDAY, arrayListOf(
                Lesson(
                    "Прикладная и оздоровительная физическая культура",
                    Time(13, 15, 0),
                    Time(14, 45, 0),
                    "Ярушин С.А.",
                    ""
                ),
                Lesson(
                    "Разработка интернет-приложений",
                    Time(19, 55, 0),
                    Time(21, 25, 0),
                    "Павличенко Е.А.",
                    "Ауд 132"
                )
            )
        ),
        Day(
            DayEnum.SATURDAY, arrayListOf(
                Lesson(
                    "Технология прикладного программирования",
                    Time(9, 40, 0),
                    Time(11, 10, 0),
                    "Веригин Н.В.",
                    "Ауд 132"
                ),
                Lesson(
                    "Технология прикладного программирования",
                    Time(11, 20, 0),
                    Time(12, 50, 0),
                    "Веригин Н.В.",
                    "Ауд 132"
                ),
                Lesson(
                    "Технология прикладного программирования",
                    Time(13, 15, 0),
                    Time(14, 45, 0),
                    "Веригин Н.В.",
                    "Ауд 132"
                ),
                Lesson(
                    "Технология прикладного программирования",
                    Time(15, 0,0),
                    Time(16, 30, 0),
                    "Веригин Н.В.",
                    "Ауд 132"
                )
            )
        ),
        Day(DayEnum.SUNDAY, arrayListOf()),
    )

    private val secondWeek: ArrayList<Day> = arrayListOf(
        Day(DayEnum.MONDAY, arrayListOf()),
        Day(
            DayEnum.TUESDAY, arrayListOf(
                Lesson(
                    "Экономика",
                    Time(16, 40, 0),
                    Time(18, 10, 0),
                    "Ткач Е.С.",
                    "Ауд 304"
                ),
                Lesson(
                    "Экономика",
                    Time(18, 20, 0),
                    Time(19, 50, 0),
                    "Ткач Е.С.",
                    "Ауд 304")
            )
        ),
        Day(
            DayEnum.WEDNESDAY, arrayListOf(
                Lesson(
                    "Управление ИТ-проектами и жизненным циклом ПО",
                    Time(18, 20, 0),
                    Time(19, 50, 0),
                    "Сметанина Ю.С.",
                    "Ауд А-15"
                ),
                Lesson(
                    "Управление ИТ-проектами и жизненным циклом ПО",
                    Time(19, 55, 0),
                    Time(21, 25, 0),
                    "Сметанина Ю.С.",
                    "Ауд А-15"
                )
            )
        ),
        Day(
            DayEnum.TUESDAY, arrayListOf(
                Lesson(
                    "Базы и хранилища данных",
                    Time(18, 20, 0),
                    Time(19, 50, 0),
                    "Барабаншиков И.В.",
                    "Ауд 132А"
                ),
                Lesson(
                    "Базы и хранилища данных",
                    Time(19, 55, 0),
                    Time(21, 25, 0),
                    "Барабаншиков И.В.",
                    "Ауд 132А"
                ),
            )
        ),
        Day(
            DayEnum.FRIDAY, arrayListOf(
                Lesson(
                    "Прикладная и оздоровительная физическая культура",
                    Time(13, 15, 0),
                    Time(14, 45, 0),
                    "Ярушин С.А.",
                    ""
                ),
                Lesson(
                    "Разработка интернет-приложений",
                    Time(18, 20, 0),
                    Time(19, 50, 0),
                    "Павличенко Е.А.",
                    "Ауд 132"
                ),
                Lesson(
                    "Разработка интернет-приложений",
                    Time(19, 55, 0),
                    Time(21, 25, 0),
                    "Павличенко Е.А.",
                    "Ауд 132"
                )
            )
        ),
        Day(
            DayEnum.SATURDAY, arrayListOf(
                Lesson(
                    "Тестирование программного обеспечения",
                    Time(9, 40, 0),
                    Time(11, 10, 0),
                    "Булавин Р.С.",
                    "Ауд 132"
                ),
                Lesson(
                    "Тестирование программного обеспечения",
                    Time(11, 20, 0),
                    Time(12, 50, 0),
                    "Булавин Р.С.",
                    "Ауд 132"
                ),
                Lesson(
                    "Базы и хранилища данных",
                    Time(13, 15, 0),
                    Time(14, 45, 0),
                    "Барабанщиков И.В.",
                    "Ауд 132"
                ),
                Lesson(
                    "Базы и хранилища данных",
                    Time(15, 0,0),
                    Time(16, 30, 0),
                    "Веригин Н.В.",
                    "Ауд 132"
                ),
                Lesson(
                    "Тестирование программного обеспечения",
                    Time(16, 40, 0),
                    Time(18, 10, 0),
                    "Булавин Р.С.",
                    "Ауд 132"
                ),
            )
        ),
        Day(DayEnum.SUNDAY, arrayListOf()),
    )
}