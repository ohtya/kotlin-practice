package etc.discount.model

import java.time.DayOfWeek
import java.time.LocalDateTime

/**
 * 休日
 */
class Holiday {

    /**
     * 休日か？
     *
     * @param date 判定したい日付（[LocalDateTime]）
     *
     * @return true: 休日, false: 平日
     */
    fun isWeekend(date: LocalDateTime): Boolean {
        return WEEKEND_DAY_OF_WEEK.contains(date.dayOfWeek)
    }

    companion object {
        /**
         * 休日
         *
         * FIXME: 今回、祝日は、考慮しないことにします
         */
        private val WEEKEND_DAY_OF_WEEK = DayOfWeek.values()
            .filter { dayOfWeek: DayOfWeek -> dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY }
    }
}