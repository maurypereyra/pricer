package common

import common.idealPriceStrategy.IIdealPriceStrategy
import theprizypricer.Price

/**
 * Created by Mauricio Pereyra on 08/02/2016.
 */
class IdealPriceCalculator {
    private IIdealPriceStrategy idealPriceStrategy

    IdealPriceCalculator(IIdealPriceStrategy idealPriceStrategy){
        this.idealPriceStrategy = idealPriceStrategy
    }

    public BigDecimal calcIdealPrice(Set<Price> prices) {
        return idealPriceStrategy.doCalculation(prices)
    }
}
