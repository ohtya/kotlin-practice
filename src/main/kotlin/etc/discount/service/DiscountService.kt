package etc.discount.service

import etc.discount.model.Drive

/**
 * 割引を実現するサービス.
 */
interface DiscountService {

    /**
     * 割引率を計算します
     *
     * @param drive [Drive]
     * @return 割引率
     */
    fun calculate(drive: Drive?): Long

    /**
     * 与えられた値を加算します(JUnit Sample)
     *
     * @param x 加算する値
     * @param y 加算する値
     * @return x + y
     */
    fun add(x: Long, y: Long): Long
}