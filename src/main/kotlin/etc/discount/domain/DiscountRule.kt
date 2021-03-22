package etc.discount.domain

import etc.discount.model.Drive


/**
 * 割引ルール
 *
 * 以下は、今回は考慮しない
 * - ETCマイレージサービス(登録済みとみなします)
 * - ETCレーンを通過したか？(必ず通過したモノとみなします)
 * - 割引適用可能な走行距離制限(仮に 110km 走行していても還元可能とみなします)
 * - 割引適用可能な利用回数制限(仮に 11回以上利用していても適用可能とみなします)
 * - 還元(本来は、即時割引と翌月20日に還元して割引の2パターンがありますが、全て即時割引とみなします)
 */
interface DiscountRule {
    /**
     * 適用可能か？
     *
     * @return true: 可能, false: 不可
     */
    fun isApplicable(drive: Drive): Boolean

    /**
     * ルールを適用した場合の割引率を返す
     *
     * @return 割引率(0から100)
     */
    fun discountRate(drive: Drive): Long
}