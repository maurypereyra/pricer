package common.idealPriceStrategy

import theprizypricer.Price

/**
 * Created by Mauricio Pereyra on 08/02/2016.
 */
class SpecialAverageIdealPriceStrategy implements common.idealPriceStrategy.IIdealPriceStrategy {
    @Override
    BigDecimal doCalculation(Set<Price> prices) {
        def pricesSortedList = prices.sort({ a, b -> a.amount <=> b.amount})
        def amountSum = prices.amount.sum()
        def amountSize = prices.amount.size()
        def amountToSubtract = 0.0
        def elementsToSubtract = 0
        if(amountSize >= 5) {
            amountToSubtract = pricesSortedList.get(0)?.amount + pricesSortedList.get(1)?.amount + pricesSortedList.get(amountSize-1)?.amount + pricesSortedList.get(amountSize-2)?.amount
            elementsToSubtract = 4
        }
        /* taking all the prices of this product, removing the 2 highest and 2 lowest, then doing an average with the rest and adding 20% to it.*/

        return (((amountSum - amountToSubtract) / (amountSize - elementsToSubtract)) * 1.20)
    }
}
