package etc.discount.service

import etc.discount.domain.DiscountRule
import etc.discount.domain.rule.Weekend
import etc.discount.model.Drive

/**
 * ETC割引を実現するサービス.
 */
class EtcDiscountService : DiscountService {

    override fun calculate(drive: Drive): Long {
        return DISCOUNT_RULES
            .filter { it.isApplicable(drive) }
            .map { it.discountRate(drive) }
            .firstOrNull() ?: 0L
    }

    override fun add(x: Long, y: Long): Long {
        return x + y
    }


    companion object {
        /**
         * 割引ルール一覧
         */
        private val DISCOUNT_RULES: List<DiscountRule> = listOf(Weekend())
    }
}