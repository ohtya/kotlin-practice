package etc.discount.model

import java.time.LocalDateTime

/**
 * 走行データ
 */
class Drive constructor(
    /**
     * 料金所に入った時間
     */
    val admissionAt: LocalDateTime,
    /**
     * 料金所から出た時間
     */
    val exitAt: LocalDateTime,
    /**
     * [CarModel]
     */
    val model: CarModel,
    /**
     * [Route]
     */
    val route: Route,
    /**
     * 1ヶ月の走行回数
     */
    val count: Long
)