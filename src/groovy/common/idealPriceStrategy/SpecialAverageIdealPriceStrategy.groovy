package common.idealPriceStrategy

import theprizypricer.Price

/**
 * Created by Mauricio Pereyra on 08/02/2016.
 */
class SpecialAverageIdealPriceStrategy implements common.idealPriceStrategy.IIdealPriceStrategy {
    @Override
    BigDecimal doCalculation(List<Price> prices) {
        def price = null

        if (prices?.amount?.size() > 0) {
            def multiplier = 1
            if(prices.amount.size() > 4) {
                prices.remove(prices.min {it.amount})
                prices.remove(prices.min {it.amount})
                prices.remove(prices.max {it.amount})
                prices.remove(prices.max {it.amount})
                multiplier = 1.20
            }

            price = new BigDecimal((prices.amount.sum()/ prices.amount.size()) * multiplier)
        }

        return price
    }
}
