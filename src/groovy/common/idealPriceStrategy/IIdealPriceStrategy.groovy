package common.idealPriceStrategy

import theprizypricer.Price

/**
 * Created by Mauricio Pereyra on 08/02/2016.
 */
interface IIdealPriceStrategy {
    BigDecimal doCalculation(Set<Price> prices)
}