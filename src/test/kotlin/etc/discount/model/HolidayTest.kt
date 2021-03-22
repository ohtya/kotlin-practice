package etc.discount.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.time.LocalDateTime
import java.util.stream.Stream

/**
 * [Holiday] unit test
 */
internal class HolidayTest {

    private lateinit var holiday: Holiday

    @BeforeEach
    fun setup() {
        holiday = Holiday()
    }

    @ParameterizedTest
    @ArgumentsSource(IsWeekendArgumentsProvider::class)
    fun isApplicable(date: LocalDateTime, expected: Boolean) {
        val actual = holiday.isWeekend(date)
        Assertions.assertEquals(expected, actual)
    }
}

internal class IsWeekendArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments?> {
        return Stream.of(
            Arguments.of(
                SATURDAY_START_AT, true
            ),
            Arguments.of(
                SATURDAY_END_AT, true
            ),
            Arguments.of(
                SUNDAY_START_AT, true
            ),
            Arguments.of(
                SUNDAY_END_AT, true
            ),
            Arguments.of(
                FRIDAY_START_AT, false
            ),
            Arguments.of(
                FRIDAY_END_AT, false
            ),
            Arguments.of(
                MONDAY_START_AT, false
            )
        )
    }

    companion object {
        private val FRIDAY_START_AT = LocalDateTime.of(2020, 2, 7, 0, 0)
        private val FRIDAY_END_AT = LocalDateTime.of(2020, 2, 7, 23, 59)
        private val SATURDAY_START_AT = LocalDateTime.of(2020, 2, 8, 0, 0)
        private val SATURDAY_END_AT = LocalDateTime.of(2020, 2, 8, 23, 59)
        private val SUNDAY_START_AT = LocalDateTime.of(2020, 2, 9, 0, 0)
        private val SUNDAY_END_AT = LocalDateTime.of(2020, 2, 9, 23, 59)
        private val MONDAY_START_AT = LocalDateTime.of(2020, 2, 10, 0, 0)
    }
}