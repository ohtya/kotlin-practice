package etc.discount.domain.rule

import etc.discount.domain.DiscountRule
import etc.discount.model.CarModel
import etc.discount.model.Drive
import etc.discount.model.Holiday
import etc.discount.model.Route


/**
 * 休日割引
 *
 * https://www.driveplaza.com/traffic/tolls_etc/etc_dis_weekend/
 *
 * 休日とは、以下を指します
 * - 土曜日
 * - 日曜日
 * - 祝日
 * - 三が日(毎年1月２日、3日)（FIXME: 祝日と三が日を休日の対象にする）
 */
class Weekend : DiscountRule {

    /**
     * 適用可能か？
     *
     * - 対象期間: 入り口料金所または出口料金所を休日に通過した場合に適用可（FIXME: 本来は休日跨ぎも適用可だが、今回は省略する）
     *
     * @param drive [Drive]
     *
     * @return true: 可能, false: 不可
     */
    override fun isApplicable(drive: Drive): Boolean {
        return APPLICABLE_ROUTE.contains(drive.route) &&
                APPLICABLE_CAR_MODEL.contains(drive.model) &&
                (HOLIDAY.isWeekend(drive.admissionAt) || HOLIDAY.isWeekend(drive.exitAt))
    }

    /**
     * 以下のルールで割引率を適用します
     *
     * - 割引率30%
     *
     * @return 割引率
     */
    override fun discountRate(drive: Drive): Long {
        return 30
    }

    companion object {
        /**
         * 割引を適用可能な車種
         *
         * 対象車種: [CarModel.KEI] or [CarModel.MEDIUM]
         */
        private val APPLICABLE_CAR_MODEL = CarModel.values()
            .filter { carModel: CarModel -> carModel == CarModel.KEI || carModel == CarModel.ORDINARY }

        /**
         * 割引を適用可能な区間
         *
         * 対象区間: [Route.LOCAL]
         */
        private val APPLICABLE_ROUTE = Route.values()
            .filter { route: Route -> route == Route.LOCAL }

        private val HOLIDAY = Holiday()
    }
}