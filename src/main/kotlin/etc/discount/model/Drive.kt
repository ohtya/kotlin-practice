package etc.discount.model

import java.time.LocalDateTime

/**
 * 走行データ
 */
class Drive constructor(
    val admissionAt: LocalDateTime,
    val exitAt: LocalDateTime,
    val model: CarModel,
    val route: Route,
    val count: Long
)