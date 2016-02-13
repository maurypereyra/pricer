package common.idealPriceStrategy

import theprizypricer.Price

/**
 * Created by Mauricio Pereyra on 08/02/2016.
 */
class SpecialAverageIdealPriceStrategy implements common.idealPriceStrategy.IIdealPriceStrategy {
    @Override
    BigDecimal doCalculation(Set<Price> prices) {
        def price = null

        if (prices?.amount.size() > 0) {
            def pricesSortedList = prices.sort({ a, b -> a.amount <=> b.amount})
            def amountSum = prices.amount.sum()
            def amountSize = prices.amount.size()
            def amountToSubtract = 0.0
            def elementsToSubtract = 0
            def multiplier = 1
            if(amountSize >= 5) {
                amountToSubtract = pricesSortedList.get(0)?.amount + pricesSortedList.get(1)?.amount + pricesSortedList.get(amountSize-1)?.amount + pricesSortedList.get(amountSize-2)?.amount
                elementsToSubtract = 4
                multiplier = 1.20
            }

            price = (((amountSum - amountToSubtract) / (amountSize - elementsToSubtract)) * multiplier)
        }

        return price
    }
}
